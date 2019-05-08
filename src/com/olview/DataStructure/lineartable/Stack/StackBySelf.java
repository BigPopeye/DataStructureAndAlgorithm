package com.olview.dayone.lineartable.Stack;

import java.util.List;

public class StackBySelf {
    public static void main(String[] args) {
        ListStack stack = new ListStack().initStack();
        stack = stack.push(1);
        stack = stack.push(2);
        stack = stack.push(3);
        System.out.println(stack.value);
        System.out.println(stack);
        System.out.println(stack.next);

        while (stack.next != null){
            stack = stack.pop(stack);// need assignment
            System.out.println(stack);
        }

    }

    public static class ListStack{
        int value;
        ListStack next;

        public  ListStack initStack(){
//            this.value = val;
            this.next = null;
            return this;
        }
        public int getTop(){
            return this.value;
        }

        public ListStack setTop(int var){
            this.value = var;
            return this;
        }

        public ListStack push(int var){
            ListStack newStack = new ListStack();
            newStack.value = var;
            newStack.next = this;
            return newStack;

        }
        public ListStack pop(ListStack stack) {
                System.out.println(stack.value);
                stack = stack.next;
                return stack;
        }
    }


}
