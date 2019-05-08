package lineartable;

public class SLList {
    /* Self-implement Single LinkedList
     * v1 : May 8, 2019
     * int linked list
     */
    public static void main(String[] args) {
        SLList slList = new SLList();
        slList.addFirst(1);
        slList.addLast(3);
        System.out.println(slList.size());
    }

    private class IntNode{
        int item;
        IntNode next;

        private IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }
    public SLList(){
        sentinel = new IntNode(66,null);
        size = 0;
    }

    private IntNode sentinel;
    private int size;

    public void addFirst(int x){
        sentinel.next = new IntNode(x,sentinel.next);
        size ++;
    }

    public int getFirst(){
        return sentinel.next.item;
    }

    public void addLast(int x){
        IntNode p = sentinel;
        while (p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x,null);

        size ++;
    }

    public int remove(int x){

    }

    public int size(){
        return size;
    }

}
