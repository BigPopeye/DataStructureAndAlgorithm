package com.olview.dayone.lineartable.list;

public class OliveLinkedList implements OliveList{

    private Node head;

    public void addFirst(int var) {
        Node new_node = new Node(var);
        new_node.next = head;
        head = new_node;
    }

    public int getFirst() {
        return this.head.value;
    }

    public int getSize() {
        Node tempNode = head;
        int size = 0;
        while (tempNode != null) {
            size++;
            tempNode = tempNode.next;
        }
        return size;
    }

    public boolean isFind(int var) {
        Node tempNode = head;
        while (tempNode != null) {
            if (tempNode.value == var) {
                return true;
            } else {
                tempNode = tempNode.next;
            }
        }
        return false;
    }

    public void addLast(int var) {
        Node newNode = new Node(var);
        if(head == null){ // 如果链表为空，则直接加
            head = newNode;
        }
        else {
            Node tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
    }

    public int getLast() {
        Node tempNode = head;
        if(tempNode == null){
            return -1;
        }
        while (tempNode.next != null){
            tempNode = tempNode.next;
        }
        return tempNode.value;
    }

    public void delete(int var) {
        Node tempNode = head;
        Node prevNode = null;

        if (tempNode != null && tempNode.value == var) {
            head = tempNode.next;
            return;
        }
        while (tempNode != null && tempNode.value != var) {
            prevNode = tempNode;
            tempNode = tempNode.next;
        }
        if (tempNode == null) {
            return;
        }

        prevNode.next = tempNode.next;
    }

    private static class Node {
        int value;
        Node next;
        Node prev;

        Node(int n) {
            value = n;
        }//构造函数Construe
        public int getValue() {
            return this.value;
        }

    }
}


