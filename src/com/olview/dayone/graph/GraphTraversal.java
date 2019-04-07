package com.olview.dayone.graph;

import java.util.LinkedList;

public class GraphTraversal {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        System.out.println(g.vertexNum);
        GraphTraversal gTest = new GraphTraversal();
        gTest.addEdgetoGraph(g,0,1);
        gTest.addEdgetoGraph(g,1,2);
        gTest.addEdgetoGraph(g,2,4);
        gTest.addEdgetoGraph(g,2,5);
        gTest.addEdgetoGraph(g,3,4);
        gTest.addEdgetoGraph(g,3,5);
        gTest.addEdgetoGraph(g,4,5);
        printGraph(g);

    }
    public static class Graph{
        int vertexNum;
        LinkedList<Integer> [] gLinkedlist;
        Graph(int n){
            vertexNum = n;
            gLinkedlist = new LinkedList[vertexNum];
            for(int i = 0;i<vertexNum;i++ ){
                gLinkedlist[i] = new LinkedList<>();
            }
        }
    }

    public void addEdgetoGraph(Graph graph,int scr,int dest){
        graph.gLinkedlist[scr].add(dest);
        graph.gLinkedlist[dest].add(scr);
    }

    public static void printGraph(Graph graph){
        for(int v = 0;v < graph.vertexNum; v++){
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");
            for(int pCrawl:graph.gLinkedlist[v]){
                System.out.print("->"+pCrawl);
            }
            System.out.println("\n");
        }
    }

}
