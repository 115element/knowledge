package com.cloud.chang.util.properties;

import com.cloud.chang.util.concurrent.FutureCancel;
import com.cloud.chang.util.concurrent.PoolShutDown;
import com.cloud.chang.util.concurrent.ThreadPool;
import com.cloud.chang.util.concurrent.UnitedThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class PropertiesManager {
    private static final Logger log = LoggerFactory.getLogger(PropertiesManager.class);
    private static final LinkedBlockingQueue<Resource> resourceQueue = new LinkedBlockingQueue<>(8192);
    private final Map<Path, List<Resource>> map4Resource = new ConcurrentHashMap<>(32);
    private final AtomicBoolean STOP = new AtomicBoolean(false);
    private final List<Future<?>> hotFutures = new ArrayList<>(32);
    private final ReadablePropertySourcesPlaceholderConfigurer resource;
    private volatile ThreadPool pool;

    private PropertiesManager(ReadablePropertySourcesPlaceholderConfigurer resource) {
        this.resource = resource;
        init();
    }

    public static PropertiesManager create(ReadablePropertySourcesPlaceholderConfigurer resource) {
        return new PropertiesManager(resource);
    }

    private void init() {
        if (null != pool) {
            throw new IllegalStateException("pool not null");
        }
        dealResource();
        createPool();
        buildRunner();
        log.info("PropertiesManager start completed");
    }

    private void dealResource() {
        List<Resource> list = shift();
        URI uri;
        Path path;
        for (Resource r : list) {
            File f = getFile(r);
            if (null == f) {
                continue;
            }
            uri = f.getParentFile().toURI();
            path = getPathFromURI(uri);
            if (null == path) {
                continue;
            }
            if (map4Resource.containsKey(path)) {
                map4Resource.get(path).add(r);
            } else {
                List<Resource> ls = new ArrayList<>();
                ls.add(r);
                map4Resource.putIfAbsent(path, ls);
            }
        }
    }

    private List<Resource> shift() {
        Resource[] resources = resource.getLocations();
        if (null == resources) {
            throw new IllegalStateException("Resource[]");
        }
        final int l = resources.length;
        if (0 >= l) {
            return new ArrayList<>(0);
        }
        List<Resource> list = new ArrayList<>(l);
        for (int i = 0; i < l; i++) {
            Resource r = resources[i];
            if (null != r) {
                list.add(r);
            }
        }
        return list;
    }

    private File getFile(final Resource r) {
        if (null == r) {
            return null;
        }
        try {
            return r.getFile();
        } catch (IOException e) {
            log.error(e.toString(), e);
            return null;
        }
    }

    private Path getPathFromURI(final URI uri) {
        if (null == uri) {
            return null;
        }
        return Paths.get(uri);
    }

    private void createPool() {
        int size = map4Resource.size() * 2;
        // ??????????????????????????????runner?????????for??????loop???????????????????????????????????????
        pool = new ThreadPool(size, size * 2, 180, TimeUnit.SECONDS, new SynchronousQueue<>(),
                UnitedThreadFactory.create("hotLoad_properties"));
    }

    private void buildRunner() {
        HotDog dog;
        PropChanged propChanged;
        Set<Path> k = map4Resource.keySet();
        if (null == k) {
            throw new NullPointerException("keySet");
        }
        for (Path p : k) {
            List<Resource> r = map4Resource.get(p);
            if (null == r) {
                throw new NullPointerException("map get");
            }
            dog = HotDog.create(p, r, STOP);
            propChanged = PropChanged.create(resourceQueue, STOP, resource);
            hotFutures.add(pool.submit(dog));
            hotFutures.add(pool.submit(propChanged));
        }
    }

    public void destory() {
        STOP.set(true);
        FutureCancel.cancel(hotFutures, true);
        PoolShutDown.threadPool(pool, "PropsCenterPool");
        cleanMap();
        log.info("PropertiesManager service shutdown completed");
    }

    private void cleanMap() {
        for (Path p : map4Resource.keySet()) {
            if (null != p) {
                List<Resource> r = map4Resource.get(p);
                if (null != r) {
                    r.clear();
                }
            }
        }
        map4Resource.clear();
    }

    public static void putReloadResource(final Resource r) {
        if (null == r) {
            log.error("list resource null");
            return;
        }
        if (!resourceQueue.offer(r)) {
            log.error("should be never happen, offer resource fail, resource=" + r);
        }
    }

}
