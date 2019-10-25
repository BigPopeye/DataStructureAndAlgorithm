package tree;

import java.util.*;

/**Self-implement Binary Search Tree using intNode
 * Two way to implement:
 * 1. recursion
 * 2. non-recursion : while loop
 * */
/* Version : v1.0
 * Date : Jun 5, 2019
 * intNode BST
 */
public class BSTree {
    private intNode root;

    private class intNode{
        int key;
        intNode left;
        intNode right;

        private intNode(int value){
            key = value;
            left = null;
            right = null;
        }
    }

    public BSTree(){
        root = null;
    }
    public BSTree(int key){
        root.key = key;
        root.left = null;
        root.right = null;
    }

    //recursion version of findKey()
    /*public intNode findKey(int key){
        return find(root,key);
    }

    private intNode find(intNode root,int key){
        if(root == null || root.key == key){
            return root;
        }else if(key > root.key){
            return find(root.right,key);
        }else{
            return find(root.left,key);
        }
    }*/

    public intNode findKey(int key){
        intNode p = root;
        while(p != null && p.key != key){
            if(key > p.key){
                p = p.right;
            }else{
                p = p.left;
            }
        }
        return p;
    }

    //recursion version of insertKey()
    /*public void insertKey(int key){
        root = insert(root,key);
    }

    private intNode insert(intNode root, int key){
        if(root == null){
            return new intNode(key);
        }
        if(key > root.key){
            root.right = insert(root.right,key);
        }else{
            root.left = insert(root.left,key);
        }
        return root;
    }*/

    public intNode insertKey(int key){
        if(root == null){
            root = new intNode(key);
            return root;
        }
        intNode p = root;
        while(p != null){
            if(key > p.key){
                if(p.right == null){
                    p.right = new intNode(key);
                    return root;
                }
                p = p.right;
            }else if(key < p.key){
                if(p.left == null){
                    p.left = new intNode(key);
                    return root;
                }
                p = p.left;
            }else{
                return root;
            }
        }
        return root;
    }



    //recursion version of removeKey()
    /*public void removeKey(int key){
        remove(root,key);
    }
    
    private intNode remove(intNode T, int key){
        if(T == null){
            return null;
        }else if(key > T.key){
            T.right = remove(T.right,key);
        }else if(key < T.key){
            T.left = remove(T.left,key);
        }else{ // find the key
            if(T.left == null){
                return T.right;
            }else if(T.right == null){
                return T.left;
            }else{
                T.key = smallest(T.right);
                T.right = remove(T.right,T.key);

            }
        }
        return T;
    }*/

    public intNode removeKey(int key){
        if(root.left == null && root.right == null && root.key == key){
            root = null;
            return root;
        }
        intNode p = root;
        intNode parent = null;
        while(p != null){
            if(key > p.key){
                parent = p;
                p = p.right;
            }else if(key < p.key){
                parent = p;
                p = p.left;
            }else{
                if(p.left == null || p.right == null){
                    if(parent.key > p.key){
                        parent.left = (p.left == null)? p.right :p.left;
                    }else{
                        parent.right = (p.right == null)? p.left :p.right;
                    }
                    break;
                }else{
                    p.key = smallest(p.right);
                    p.right = delsmallest(p.right);
                    break;
                }
            }
        }
        return root;
    }
    
    /**1.Move the key from the first node in T(in a inorder traversal) to node R(overwriting the current key of R)
     * 2.Remove the first node of T from T, and return the resulting tree*/
    private static int smallest(intNode T){
        int smallv = T.key;
        while(T.left != null){
            smallv = T.left.key;
            T = T.left;
        }
        return smallv;
    }

    private intNode delsmallest(intNode T){
        intNode p = T;
        intNode parent = null;
        while(p.left != null){
            parent = p;
            p = p.left;
        }
        if(p.right != null){
            parent.right = p.right;
        }else{
            if(parent.key > p.key){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
        return T;
    }

    // inorder traversal recursion
    // This method mainly calls InorderRec()
    public void inorder()
    {
        if(root != null){
            inorderRec(root);
        }else{
            System.out.println("The tree is empty!");
        }

    }
    private void inorderRec(intNode root)
    {
        if (root != null)
        {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public List<Integer> inorderTraversal(intNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<intNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                list.add(root.key);
                root = root.right;
            }
        }
        return list;
    }

    public List<Integer> postorderTraversal(intNode root) {
        if(root == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Stack<intNode> stack1 = new Stack<>();
        Stack<intNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            root = stack1.peek();
            if(root != null){
                stack2.push(root);
                stack1.pop();
                if(root.left != null){
                    stack1.push(root.left);
                }
                if(root.right != null){
                    stack1.push(root.right);
                }
            }
        }
        while(!stack2.isEmpty()){
            root = stack2.peek();
            list.add(root.key);
            stack2.pop();
        }
        return list;
    }

    public List<Integer> binaryTreePaths(intNode root) {
        List<Integer> answer = new ArrayList<Integer>();
        if (root != null) searchBT(root, 0, answer);
        return answer;
    }
    private void searchBT(intNode root, int path, List<Integer> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.key);
        if (root.left != null) searchBT(root.left, path + root.key , answer);
        if (root.right != null) searchBT(root.right, path + root.key, answer);
    }


    public static void main(String[] args)
    {
//        BSTree tree = new BSTree();
//
//        /* Let us create following BST
//              50
//           /     \
//          30      70
//         /  \    /  \
//        20   40  60   80 */
//        tree.insertKey(50);
//        tree.insertKey(30);
//        tree.insertKey(20);
//        tree.insertKey(40);
//        tree.insertKey(70);
//        tree.insertKey(60);
//        tree.insertKey(80);


        //LinkedList<Integer> list = new LinkedList<>();
        int[] arr = new int[]{3,2,5,7,8};
        //Arrays.sort(arr);

        System.out.println(arr[0]);


//        List<Integer> list1 = tree.inorderTraversal(tree.root);
//        System.out.println(list1);
//
//        List<Integer> list2 = tree.postorderTraversal(tree.root);
//        System.out.println(list2);

//        List<Integer> lists = tree.binaryTreePaths(tree.root);
//        System.out.println(lists);



        /*System.out.println(tree.findKey(20).key + "is in the tree;");

        System.out.println("Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nDelete 20");
        tree.removeKey(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 30");
        tree.removeKey(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.removeKey(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 70");
        tree.removeKey(70);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 80");
        tree.removeKey(80);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 40");
        tree.removeKey(40);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 60");
        tree.removeKey(60);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();*/
    }
}
