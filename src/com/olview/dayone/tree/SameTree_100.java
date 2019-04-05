package com.olview.dayone.tree;

import java.util.TreeMap;

public class SameTree_100 {
    public static void main(String[] args) {
        TreeNode bstTree1 = new TreeNode(10);
        TreeNode bstTree2 = new TreeNode(10);

        SameTree_100 bstTest1 = new SameTree_100();
        bstTest1.Insert(5,bstTree1);
        bstTest1.Insert(9,bstTree1);
        bstTest1.Insert(12,bstTree1);
        bstTest1.Insert(2,bstTree1);
        bstTest1.Insert(3,bstTree1);

        SameTree_100 bstTest2 = new SameTree_100();
        bstTest2.Insert(5,bstTree2);
        bstTest2.Insert(9,bstTree2);
        bstTest2.Insert(12,bstTree2);
        bstTest2.Insert(2,bstTree2);
        bstTest2.Insert(3,bstTree2);

        boolean result = bstTest1.isSameTree(bstTree1,bstTree2);
        System.out.println(result);
    }

    public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
//        System.out.println("p:"+p.val+"&q:"+q.val);
        if( p == null || q == null ){
            return false;
        }
        if(p.val!=q.val){return false;}
        boolean result = isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        System.out.println("p->"+p.val+"||q->"+q.val);

        return result;
    }

    public TreeNode Insert(int var,TreeNode bstTree){
        if(bstTree == null){
            bstTree = new TreeNode(var);//初始化一个树
            return bstTree;
        }else {
            if (var < bstTree.val){
                bstTree.left = Insert(var,bstTree.left);
            }else if(var > bstTree.val){
                bstTree.right = Insert(var,bstTree.right);
            }
            return bstTree; //如果要插入的值已经存在，则直接返回
        }
    }

}
