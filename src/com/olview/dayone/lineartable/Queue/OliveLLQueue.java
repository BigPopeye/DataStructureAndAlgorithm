package com.olview.dayone.lineartable.Queue;

import com.olview.dayone.lineartable.list.OliveLinkedList;
import com.olview.dayone.lineartable.list.OliveList;

public class OliveLLQueue {
    public static void main(String[]args){
        OliveLLQueue queue = new OliveLLQueue();
        for(int i = 0;i<5;i++){
            queue.enQueue(i+1);
            System.out.println("\nThe Size Of Queue is: "+queue.getSize());
            System.out.println("The Tail of the Queue is : " +queue.peek());
        }
        for (int i = 0;i<5;i++){
            queue.deQueue();
            System.out.println("\nThe Size Of Queue is: "+queue.getSize());
            System.out.println("The Tail of the Queue is : " +queue.peek());
        }
    }


    private OliveList oliveList;

    public OliveLLQueue(){ oliveList = new OliveLinkedList(); }

    public void enQueue(int value){
        oliveList.addLast(value);
    }

    public void deQueue(){
        int tempQueueItem = oliveList.getFirst();
        oliveList.delete(tempQueueItem);
    }

    public int peek(){
        return oliveList.getLast();
    }

    public int getSize(){
        return oliveList.getSize();
    }
}
