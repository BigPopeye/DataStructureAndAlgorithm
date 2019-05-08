package com.olview.dayone.tree;

import java.util.*;

public class BinaryTree{

    public static void main(String[] args) {
        BinTree btTree1 = new BinTree(1);
        BinTree btTree2 = new BinTree(2);
        BinTree btTree3 = new BinTree(3);
        BinTree btTree4 = new BinTree(4);
        BinTree btTree5 = new BinTree(5);
        BinTree btTree6 = new BinTree(6);

        btTree1.left = btTree2;
        btTree1.right = btTree3;
        btTree2.left = btTree4;
        btTree2.right = btTree5;
        btTree3.right = btTree6;

        BinaryTree test = new BinaryTree();
        //递归方式实现树的遍历
        System.out.println("->PreOrder:");
        test.PreOrderTraversal(btTree1);
        System.out.println("->InOrder:");
        test.InOrderTraversal(btTree1);
        System.out.println("->PostOrder:");
        test.PostOrderTraversal(btTree1);
        //用栈的方式实现树的遍历
        System.out.println("->PreOrder:");
        test.PreOrderTraversalS(btTree1);
        System.out.println("->InOrder:");
        test.InOrderTraversalS(btTree1);
        System.out.println("->PostOrder:");
        test.PostOrderTraversalS(btTree1);
        // 用队列的方式实现树的层序遍历
        System.out.println("->LevelOrder:");
        test.LevelOrderTraversalQ(btTree1);
    }

    public static class BinTree{
        int value;
        BinTree left;
        BinTree right;
        BinTree(int n){
            value = n;
            left = null;
            right = null;
        }
    }

/*
* 采用递归的方式遍历树*/
    public void PreOrderTraversal(BinTree BT){
        if(BT != null){
            System.out.println(BT.value);
            PreOrderTraversal(BT.left);
            PreOrderTraversal(BT.right);
        }
    }
    public void InOrderTraversal(BinTree BT){
        if(BT != null){
            InOrderTraversal(BT.left);
            System.out.println(BT.value);
            InOrderTraversal(BT.right);
        }

    }
    public void PostOrderTraversal(BinTree BT){
        if(BT != null){
            PostOrderTraversal(BT.left);
            PostOrderTraversal(BT.right);
            System.out.println(BT.value);
        }
    }
/*采用栈的方式遍历树*/
    public void PreOrderTraversalS(BinTree BT){
        Stack<BinTree> stack = new Stack<>();  //stack的实例化需要指明类型
        while (BT !=null || !stack.isEmpty()) {
            while (BT != null) {
                System.out.println(BT.value);
                stack.push(BT);
                BT = BT.left;
            }
            if (!stack.isEmpty()) {
                BT = stack.pop(); //弹出的元素作为新的栈顶，才可以保留根节点，从而访问右儿子
                BT = BT.right;
            }
        }
    }
    public void InOrderTraversalS(BinTree BT){
        Stack<BinTree> stack = new Stack<>();
        while (BT !=null || !stack.isEmpty()) {
            while (BT != null) {
                stack.push(BT);
                BT = BT.left;
            }
            if (!stack.isEmpty()) {
                BT = stack.pop(); //弹出的元素作为新的栈顶，才可以保留根节点，从而访问右儿子
                System.out.println(BT.value);
                BT = BT.right;
            }
        }
    }

    public void PostOrderTraversalS(BinTree BT){ //通过2个栈来实现
        if(BT == null){
            return;
        }
        Stack<BinTree> stack1 = new Stack<>();
        Stack<BinTree> stack2 = new Stack<>();
        stack1.push(BT);
        while (!stack1.isEmpty()){ //通过栈2作为中转，倒置将要打印出来的元素
            BT = stack1.peek();
            if(BT !=null){
                stack2.push(BT); //当栈1的顶元素不为空，则push到栈2
                stack1.pop(); //栈1弹出顶
                if (BT.left !=null){ //栈2从顶端判断是否有左儿子or右儿子，如有且不为空，则压入栈1
                    stack1.push(BT.left);
                }
                if(BT.right != null){
                    stack1.push(BT.right);
                }
            }
        }
        while (!stack2.isEmpty()){
            BT = stack2.peek();
            System.out.println(BT.value);
            stack2.pop();
        }
    }
/*
* 采用队列的方式层序遍历树*/
    public void LevelOrderTraversalQ(BinTree BT){
        if(BT == null){
            return;
        }
        Queue<BinTree> queue = new LinkedList<>();
        queue.add(BT);
        while (queue.size() !=0){
            BT = queue.poll();
            System.out.println(BT.value);
            if(BT.left != null){
                queue.add(BT.left);
            }
            if(BT.right != null){
                queue.add(BT.right);
            }
        }

    }
}
