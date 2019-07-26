package lineartable;
//import edu.princeton.cs.algs4.StdIn;
//import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;


public class ResizingArrayStack<Item> implements Iterable<Item>{
    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>(100);
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
        /*
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-")){
                stack.push(item);
            }
            else if(!stack.isEmpty()){
                StdOut.print(stack.pop()+" ");
            }
        }
        StdOut.print(stack.size());*/
    }

    private Item[] a;
    private int size;
    public ResizingArrayStack(int cap){
        a = (Item[])new Object[cap];
    }
    public void push(Item item){
        if(size == a.length){
            resize(2*a.length);
        }
        a[size++] = item;
    }

    public Item pop(){
        Item item =  a[--size];
        a[size] = null;
        if(size > 0 && size == a.length/4){
            resize(a.length/2);
        }
        return item;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i < size; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item>{
        private int i = size;
        public boolean hasNext(){
            return i > 0;
        }
        public Item next(){
            return a[--size];
        }
        public void remove(){}
    }
}
