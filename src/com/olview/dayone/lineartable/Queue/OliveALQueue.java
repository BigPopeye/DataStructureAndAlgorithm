package com.olview.dayone.lineartable.Queue;

import com.olview.dayone.lineartable.list.OliveArrayList;
import com.olview.dayone.lineartable.list.OliveList;

public class OliveALQueue {
    public static void main(String[]args){
        OliveALQueue queue = new OliveALQueue();
        for(int i = 0;i<5;i++){
            queue.enQueue(i+1);
            System.out.println("\nThe Size Of Queue is: "+queue.getSize());
            System.out.println("The Tail of the Queue is : " +queue.peek());
        }
        for (int i = 0;i<4;i++){
            queue.deQueue();
            System.out.println("\nThe Size Of Queue is: "+queue.getSize());
            System.out.println("The Tail of the Queue is : " +queue.peek());
        }
    }


    private int[] oliveArray;
    private int maxSize = 100;
    private int head = 0; //第一个可以弹出值的位置
    private int rear = 0; //第一个可以添加值的位置

    public OliveALQueue(){ oliveArray = new int[maxSize]; }

    public void enQueue(int value){
        int size = this.getSize();
        if(size < maxSize && size >=0 ){
            oliveArray[rear] = value;
            rear = (rear + 1) % maxSize;
        }else if(size >= maxSize){
            System.out.println("\nStack OverFlow!");
        }else {System.out.println("\nStack UnderFlow!");}
    }

    public void deQueue(){
        int size = this.getSize();
        if (size >0 ){
            head = (head + 1) % maxSize;
        }else {
            System.out.println("\nStack UnderFlow!");
        }
    }

    public int peek(){
        int size = this.getSize();
        if(size > 0){
            return oliveArray[head];
        }else return -1;
    }

    public int getSize(){
        if(rear < head){
            return maxSize - head + rear;
        }else if(rear > head){
            return rear - head;
        }else return 0;
    }
}
