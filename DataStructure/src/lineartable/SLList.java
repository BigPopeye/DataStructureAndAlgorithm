package lineartable;

public class SLList implements OList{
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

    @Override
    public void addFirst(int x){
        sentinel.next = new IntNode(x,sentinel.next);
        size ++;
    }

    @Override
    public int getFirst(){

        return sentinel.next.item;
    }

    @Override
    public void addLast(int x){
        IntNode p = sentinel;
        while (p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x,null);

        size ++;
    }

    @Override
    public int getLast() {
        IntNode p = sentinel;
        while (p.next != null){
            p = p.next;
        }
        return p.item;
    }

    @Override
    public int removeLast() {
        IntNode p = sentinel;
        if(size == 0){
            return -1;
        }
        while (p.next.next != null){
            p = p.next;
        }
        p.next = null;
        size --;
        return p.item;
    }

//    public int removeFirst(){
//
//    }
//
//    public int removeLast(){
//
//    }
//
    @Override
    public int size(){
        return size;
    }


}
