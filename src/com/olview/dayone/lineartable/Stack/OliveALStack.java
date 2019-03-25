package com.olview.dayone.lineartable.Stack;

import com.olview.dayone.lineartable.list.OliveArrayList;
import com.olview.dayone.lineartable.list.OliveList;

public class OliveALStack {
    public static void main(String[]args){
        OliveALStack stack = new OliveALStack();
        for(int i=0;i<5;i++){
            stack.push(i+1);
            System.out.println("\nThe Size of the Stack is："+stack.getSize());
            System.out.println("\nThe Top of the Stack is："+stack.peek());
        }
        for (int i=0;i<3;i++){
            stack.pop();
            System.out.println("\nThe Size of the Stack is："+stack.getSize());
            System.out.println("\nThe Top of the Stack is："+stack.peek());
        }
    }

    private OliveList oliveList;

    public OliveALStack(){
        oliveList = new OliveArrayList();
    }

    public int pop(){
        int stackTopItem = oliveList.getLast();
        oliveList.delete(stackTopItem);
        return stackTopItem;
    }

    public void push(int value){
        oliveList.addLast(value);
    }

    public int getSize(){
        return oliveList.getSize();
    }

    public int peek(){
        return oliveList.getLast();

    }

}
