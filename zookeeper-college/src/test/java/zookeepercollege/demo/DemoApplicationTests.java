package zookeepercollege.demo;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.transaction.CuratorTransaction;
import org.apache.zookeeper.CreateMode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    private CuratorFramework curatorClient;


    //获取zookeeper所有节点
    @Test
    public void getAllNode() {
        getNode("/");
    }
    public void getNode(String parentNode) {
        try {
            List<String> tmpList = curatorClient.getChildren().forPath(parentNode);
            for (String tmp : tmpList) {
                String childNode = parentNode.equals("/") ? parentNode + tmp : parentNode + "/" + tmp;
                System.out.println(childNode);
                getNode(childNode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //创建节点
    @Test
    void test1() throws Exception {
        //创建结点，输出如下：
        //        treeCache, type:NODE_ADDED
        //        treeCache, nodePath:/zk data: type:NODE_ADDED
        //        nodeChanged,nodePath:/zk data:
        String s = curatorClient.create().creatingParentsIfNeeded().forPath("/zk3");
        System.out.println(s);
    }


    @Test
    void test2() throws Exception {
        //创建结点，同时设置值，输出如下：
        //        treeCache, type:NODE_ADDED
        //        treeCache, nodePath:/zk data: type:NODE_ADDED
        //        nodeChanged,nodePath:/zk data:
        curatorClient.create().creatingParentsIfNeeded().forPath("/zk", "this is zk1".getBytes());
    }

    @Test
    void test3() throws Exception {
        //单独设置结点值
        curatorClient.setData().forPath("/zk", "this is zk6".getBytes());
    }


    @Test
    void test4() throws Exception {
        //创建包含父结点的结点，输出如下：
        //        treeCache, type:NODE_ADDED
        //        treeCache, nodePath:/zk/one data:this is one type:NODE_ADDED
        curatorClient.create().creatingParentsIfNeeded().forPath("/zk/one", "this is one".getBytes());
    }


    @Test
    void test5() throws Exception {
        //单独设置结点值，输出如下：
        //        treeCache, type:NODE_UPDATED
        //        treeCache, nodePath:/zk/one data:this is zk one2 type:NODE_UPDATED
        curatorClient.setData().forPath("/zk/one", "this is zk one2".getBytes());
    }


    @Test
    void zkTest() throws Exception {
        //事务，执行多个操作
        CuratorTransaction curatorTransaction = curatorClient.inTransaction();
        curatorTransaction.create().withMode(CreateMode.EPHEMERAL).forPath("/zk/three", "this is three".getBytes())
                .and().create().withMode(CreateMode.PERSISTENT).forPath("/zk/four", "this is four".getBytes())
                .and().commit();
    }


    @Test
    void test6() throws Exception {
        /**
         * guaranteed() ：确保节点被删除
         * withVersion(-1)： 指定删除的哪个版本
         * deletingChildrenIfNeeded() ： 递归删除。包括子节点。
         */
        Void zk = curatorClient.delete()
                //.withVersion(-1)   //指定删除的哪个版本
                .guaranteed()  //确保节点被删除
                .deletingChildrenIfNeeded()  //递归删除
                .forPath("/zk3");
        System.out.println(zk);

        getAllNode();
    }


}
