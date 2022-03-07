package com.example.graph;

import com.example.graph.bean.DataEntity;
import com.example.graph.bean.DataRelationShip;
import com.example.graph.bean.Edge;
import com.example.graph.bean.Node;
import com.google.common.base.Preconditions;
import com.google.common.graph.Graphs;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;
import org.apache.commons.lang3.StringUtils;

public class LearnGraphChapter1 {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        /**
         * <pre>
         * Graph
         *           a  -> c
         *              -> b -> d -> e
         * </pre>
         */
        MutableValueGraph<Node<DataEntity>, Edge<DataRelationShip>> graph = ValueGraphBuilder.directed().build();
        String nameSpace = "nameSpace";
        Node<DataEntity> a = new DataEntity(nameSpace, "a");
        Node<DataEntity> b = new DataEntity(nameSpace, "b");
        Node<DataEntity> c = new DataEntity(nameSpace, "c");
        Node<DataEntity> d = new DataEntity(nameSpace, "d");
        Node<DataEntity> e = new DataEntity(nameSpace, "e");

        Node<DataEntity> eClone = new DataEntity(nameSpace, "e");

        Edge<DataRelationShip> ab = new DataRelationShip("a", "b");
        Edge<DataRelationShip> ac = new DataRelationShip("a", "c");
        Edge<DataRelationShip> bd = new DataRelationShip("b", "d");
        Edge<DataRelationShip> de = new DataRelationShip("d", "e");
        //Edge<DataEntity> ea = new DataRelationShip("e","a");


        putEdgeValue(graph, a, b, ab);
        putEdgeValue(graph, a, c, ac);
        putEdgeValue(graph, b, d, bd);
        putEdgeValue(graph, d, e, de);
        // putEdgeValue(graph, e, a, ea);

        System.out.println(graph.toString());
        System.out.println(Graphs.hasCycle(graph.asGraph()));
        System.out.println(graph.adjacentNodes(b)); //adjacent 邻近的
        System.out.println(StringUtils.repeat("-", 100));
        System.out.println(graph.predecessors(a));
        System.out.println(graph.successors(a));
        System.out.println(StringUtils.repeat("-", 100));
        System.out.println(graph.predecessors(b));
        System.out.println(graph.successors(b));
        System.out.println(StringUtils.repeat("-", 100));
        System.out.println(graph.predecessors(eClone)); //predecessors 前任
        System.out.println(graph.successors(eClone)); //successors 继承人

        /**
         *
         * output:
         *
         * <pre>
         * isDirected: true, allowsSelfLoops: false, nodes: [DataEntity [nameSpace=nameSpace, entityName=a], DataEntity [nameSpace=nameSpace, entityName=b], DataEntity [nameSpace=nameSpace, entityName=c], DataEntity [nameSpace=nameSpace, entityName=d], DataEntity [nameSpace=nameSpace, entityName=e]], edges: {<DataEntity [nameSpace=nameSpace, entityName=a] -> DataEntity [nameSpace=nameSpace, entityName=c]>=DataRelationShip [sourceColumn=a, targetColumn=c], <DataEntity [nameSpace=nameSpace, entityName=a] -> DataEntity [nameSpace=nameSpace, entityName=b]>=DataRelationShip [sourceColumn=a, targetColumn=b], <DataEntity [nameSpace=nameSpace, entityName=b] -> DataEntity [nameSpace=nameSpace, entityName=d]>=DataRelationShip [sourceColumn=b, targetColumn=d], <DataEntity [nameSpace=nameSpace, entityName=d] -> DataEntity [nameSpace=nameSpace, entityName=e]>=DataRelationShip [sourceColumn=d, targetColumn=e]}
         * false
         * [DataEntity [nameSpace=nameSpace, entityName=d], DataEntity [nameSpace=nameSpace, entityName=a]]
         * ----------------------------------------------------------------------------------------------------
         * []
         * [DataEntity [nameSpace=nameSpace, entityName=c], DataEntity [nameSpace=nameSpace, entityName=b]]
         * ----------------------------------------------------------------------------------------------------
         * [DataEntity [nameSpace=nameSpace, entityName=a]]
         * [DataEntity [nameSpace=nameSpace, entityName=d]]
         * ----------------------------------------------------------------------------------------------------
         * [DataEntity [nameSpace=nameSpace, entityName=d]]
         * []
         *
         * </pre>
         */


    }

    public static void putEdgeValue(MutableValueGraph<Node<DataEntity>, Edge<DataRelationShip>> graph,
                                    Node<DataEntity> a,
                                    Node<DataEntity> b,
                                    Edge<DataRelationShip> ab) {
        graph.putEdgeValue(a, b, ab);
        Preconditions.checkArgument(!Graphs.hasCycle(graph.asGraph()),
                "from node:%s to node:%s with the edge:%s will form the cycle.", a, b, ab);
    }
}
