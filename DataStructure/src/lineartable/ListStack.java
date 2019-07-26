package lineartable;

import java.util.Iterator;

public class ListStack<Item> implements Iterable<Item> {
    public static void main(String[] args) {
        ListStack<String> stack = new ListStack<>();
        String string = "to be or not to - be - - that - - - is";
        String[] strings = string.split(" ");
        for(String s : strings){
            if(!s.equals("-")){
                stack.push(s);
            }else if(stack.iterator().hasNext()){
                System.out.print(stack.pop()+" ");
            }
        }
        System.out.println("(" + stack.size() + " left on stack)");
    }

    private int size;
    private Node head;
    private class Node{
        Item item;
        Node next;
    }

    public void push(Item item){
        Node oldhead = head;
        head = new Node();
        head.item = item;
        head.next = oldhead;
        size++;
    }

    public Item pop(){
        Item item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = head;
        public boolean hasNext(){
            return current != null;
        }
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove(){

        }
    }
}
