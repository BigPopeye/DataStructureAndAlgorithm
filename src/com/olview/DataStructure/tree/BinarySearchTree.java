package com.olview.dayone.tree;
import java.util.Scanner;
import java.util.*;

public class BinarySearchTree {
    public static void main(String[] args) {
        BST bstTree = new BST(10);

        BinarySearchTree bstTest = new BinarySearchTree();
        bstTest.Insert(5,bstTree);
        bstTest.Insert(9,bstTree);
        bstTest.Insert(12,bstTree);
        bstTest.Insert(2,bstTree);
        bstTest.Insert(3,bstTree);
        System.out.println("\nBST Tree is:(InOrder)");
        bstTest.InOrderTraversal(bstTree);
        System.out.println("\nBST Tree is:(PostOrder)");
        bstTest.PostOrderTraversalS(bstTree);
        System.out.println("\nThe Minimal value of BST Tree is:");
        System.out.println(bstTest.FindMin(bstTree).value);
        System.out.println("\nThe Maximal value of BST Tree is:");
        System.out.println(bstTest.FindMax(bstTree).value);
        System.out.println("\nInsert the number you want to delete:");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        bstTree = bstTest.Delete(num,bstTree);
        System.out.println("\nThe new Tree after you delete:");
        bstTest.InOrderTraversal(bstTree);
    }


    public static class BST{
        int value;
        BST left;
        BST right;
        BST(int n){
            value = n;
            left = null;
            right = null;
        }
    }

    public BST Find(int var,BST bstTree){
        if(bstTree == null){
            return null;
        }
        while (bstTree != null){
            if(var < bstTree.value){
                bstTree = bstTree.left;
            }else if(var > bstTree.value){
                bstTree = bstTree.right;
            }else return bstTree;
        }
        return null;
    }
    public BST FindMin(BST bstTree){
        if(bstTree == null){
            return null;
        }
        while (bstTree.left != null){
            bstTree = bstTree.left;
        }
        return bstTree;
    }

    public BST FindMax(BST bstTree){
        if(bstTree == null){
            return null;
        }
        while (bstTree.right != null){
            bstTree = bstTree.right;
        }
        return bstTree;
    }

    public BST Insert(int var,BST bstTree){
        if(bstTree == null){
            bstTree = new BST(var);//初始化一个树
            return bstTree;
        }else {
            if (var < bstTree.value){
                bstTree.left = Insert(var,bstTree.left);
            }else if(var > bstTree.value){
                bstTree.right = Insert(var,bstTree.right);
            }
            return bstTree; //如果要查入的值已经存在，则直接返回
        }
    }

    public BST Delete(int var,BST bstTree){
        BST temp;
        if(bstTree == null){
            System.out.println("在该树中未找到需要删除的元素");
        }else if(var < bstTree.value){
            bstTree.left = Delete(var,bstTree.left);
        }else if(var > bstTree.value){
            bstTree.right = Delete(var,bstTree.right);
        }else { //找到了要删除的点
            if(bstTree.left != null && bstTree.right != null){
                temp = FindMin(bstTree.right);//在右子树中找到最小的节点，填充该节点
                bstTree.value = temp.value;
                bstTree.right = Delete(bstTree.value,bstTree.right);//删除右子树中最小的节点
            }else { //被删除的节点有一个或者没有子节点
                if(bstTree.left == null){
                    bstTree = bstTree.right;
                }else{
                    bstTree = bstTree.left;
                }
            }
        }return bstTree;
    }

    public void InOrderTraversal(BST bstTree){
        if(bstTree != null){
            InOrderTraversal(bstTree.left);
            System.out.println(bstTree.value);
            InOrderTraversal(bstTree.right);
        }
    }

    public void PostOrderTraversalS(BST bstTree){ //通过2个栈来实现
        if(bstTree == null){
            return;
        }
        Stack<BST> stack1 = new Stack<>();
        Stack<BST> stack2 = new Stack<>();
        stack1.push(bstTree);
        while (!stack1.isEmpty()){ //通过栈2作为中转，倒置将要打印出来的元素
            bstTree = stack1.peek();
            if(bstTree !=null){
                stack2.push(bstTree); //当栈1的顶元素不为空，则push到栈2
                stack1.pop(); //栈1弹出顶
                if (bstTree.left !=null){ //栈2从顶端判断是否有左儿子or右儿子，如有且不为空，则压入栈1
                    stack1.push(bstTree.left);
                }
                if(bstTree.right != null){
                    stack1.push(bstTree.right);
                }
            }
        }
        while (!stack2.isEmpty()){
            bstTree = stack2.peek();
            System.out.println(bstTree.value);
            stack2.pop();
        }
    }
}
