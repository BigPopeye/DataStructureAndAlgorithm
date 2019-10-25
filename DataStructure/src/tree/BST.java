package tree;

/**Self-implement Binary Search Tree without using intNode*/

/* Version : v1.0
 * Date : Jun 4, 2019
 * int BST
 */
public class BST {
    private int key;
    private BST left;
    private BST right;


    public BST(){

    }
    public BST(int key){
        this.key = key;
        left = null;
        right = null;
    }

    public BST findKey(int key){
        return find(this,key);
    }
    private static BST find(BST T, int key){
        if(T.key == key || T == null){
            return T;
        }else if(key > T.key){
            return find(T.right,key);
        }else{
            return find(T.left,key);
        }
    }

    public void insertKey(int key){
        insert(this,key);
    }

    private BST insert(BST T, int key){
        if(T == null){
            return new BST(key);
        }
        if(key < T.key){
            T.left = insert(T.left,key);
        }else{
            T.right = insert(T.right,key);
        }
        return T;
    }

    public void removeKey(int key){
        remove(this,key);
    }
    
    private BST remove(BST T, int key){
        if(T == null){
            return null;
        }else if(key < T.key){
            T.left = remove(T.left,key);
        }else if(key > T.key){
            T.right = remove(T.right,key);
        }else{                  //find it
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
    }
    
    /**1.Move the key from the first node in T(in a inorder traversal) to node R(overwriting the current key of R)
     * 2.Remove the first node of T from T, and return the resulting tree*/
    public static int smallest(BST T){
        int smallv = T.key;
        while(T.left != null){
            smallv = T.left.key;
            T = T.left;
        }
        return smallv;
    }

    // This method mainly calls InorderRec()
    void inorder()
    {
        inorderRec(this);
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(BST root)
    {
        if (root != null)
        {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }


    public static void main(String[] args)
    {
        BST tree = new BST(50);

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        //tree.insertKey(50);
        tree.insertKey(30);
        tree.insertKey(20);
        tree.insertKey(40);
        tree.insertKey(70);
        tree.insertKey(60);
        tree.insertKey(80);

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
    }
}
