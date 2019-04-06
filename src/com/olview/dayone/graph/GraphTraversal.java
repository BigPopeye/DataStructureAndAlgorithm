package com.olview.dayone.graph;

import java.util.LinkedList;

public class GraphTraversal {
    public static void main(String[] args) {
        Graph g = new Graph(2);
        System.out.println(g.vertexNum);
        GraphTraversal gTest = new GraphTraversal();
        gTest.addEdgetoGraph(g,0,1);
        System.out.println(g.gLinkedlist[0]);
        System.out.println(g.gLinkedlist[1]);

    }
    public static class Graph{
        int vertexNum;
        LinkedList<Integer>[] gLinkedlist;
        Graph(int n){
            vertexNum = n;
            gLinkedlist = new LinkedList[vertexNum];
            for(int i = 0;i<vertexNum;i++){
                gLinkedlist[i] = new LinkedList<>();
            }
        }
    }
    public void addEdgetoGraph(Graph graph,int scr,int dest){
        graph.gLinkedlist[scr].add(dest);
        graph.gLinkedlist[dest].add(scr);
    }
}
