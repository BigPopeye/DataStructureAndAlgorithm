package com.olview.dayone.lineartable.Stack;

import com.olview.dayone.lineartable.list.OliveLinkedList;
import com.olview.dayone.lineartable.list.OliveList;

public class OliveLLStack {
    public static void main(String[]args){
        OliveLLStack stack = new OliveLLStack();
        for(int i=0;i<5;i++){
            stack.push(i+1);
            System.out.println("\nThe Size of the Stack is："+stack.getSize());
            System.out.println("\nThe Top of the Stack is："+stack.peek());
        }
        for (int i=0;i<4;i++){
            stack.pop();
            System.out.println("\nThe Size of the Stack is："+stack.getSize());
            System.out.println("\nThe Top of the Stack is："+stack.peek());
        }
    }

    private OliveList oliveList;

    public OliveLLStack(){
        oliveList = new OliveLinkedList();
    }

    public int pop(){
        int stackTopItem = oliveList.getFirst();
        oliveList.delete(stackTopItem);
        return stackTopItem;
    }

    public void push(int value){
        oliveList.addFirst(value);
    }

    public int getSize(){
        return oliveList.getSize();
    }

    public int peek(){
        return oliveList.getFirst();

    }

}
