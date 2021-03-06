package com.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

@Slf4j
public class FluxMonoTestCase {

    @Test
    public void subscribe() {
        Flux<String> stringFlux = Flux.just("Hello", "World");
        //stringFlux.subscribe(System.out::println);
        //订阅方式一
        stringFlux.subscribe(val -> {
            System.out.println("val:" + val);
            //log.info("val:{}", val);
        }, error -> {
            System.out.println("error:" + error);
            //log.error("error:", error);
        }, () -> {
            System.out.println("finished");
            //log.info("Finished");
        }, subscription -> {
            subscription.request(1);
        });
        //订阅方式二
        stringFlux.subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext:"+s);
                //log.info("onNext:{}", s);
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
                //log.info("onComplete");
            }
        });
    }
}
