package com.olview.dayone.lineartable.list;

import java.util.LinkedList;
import java.util.List;

public class ListReverseNode {
    public static void main(String[] args) {
        Node nodehead = new Node();
        Node node1 = new Node();
        Node node2 = new Node();

        nodehead.value = nodehead.setValue(0);
        node1.value = node1.setValue(1);
        node2.value = node2.setValue(2);

        nodehead.next = nodehead.setNext(node1);
        node1.next = node1.setNext(node2);


        Node nodeTest = new ListReverseNode().reverseNode(nodehead);
        iterateNode(nodeTest);

    }

    public static void iterateNode(Node node){
        Node tempNode = node;
        while (tempNode != null ){
            System.out.println(tempNode.value);
            tempNode = tempNode.next;
        }
    }

    public Node reverseNode(Node node){
        Node tempNode = node;
        Node newHead = null;

        while(tempNode != null){
            Node nextNode = tempNode.next;

            tempNode.next = newHead;
            newHead = tempNode;
            tempNode = nextNode;

        }
        return newHead;

    }


    public static class Node{
        int value;
        Node next;

        public int getValue(){
            return this.value;
        }
        public int setValue(int a){
            this.value = a;
            return value;
        }

        public Node getNext(){
            return this.next;
        }

        public Node setNext(Node n){
            this.next = n;
            return next;
        }
    }
}
