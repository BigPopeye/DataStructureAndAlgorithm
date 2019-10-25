package lineartable;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, DNode> map ;
    DNode lhead;
    DNode ltail;
    class DNode{
        int value;
        DNode prev;
        DNode next;
        private DNode(int val){
            value = val;
            prev = null;
            next = null;
        }
    }
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, DNode>();
        lhead = new DNode(-1);
        ltail = new DNode(-1);
        lhead.next = ltail;
        ltail.prev = lhead;
    }

    public int get(int key) {
        if(map.get(key) == null){
            return -1;
        }else{
            int val = map.get(key).value;
            updateRecentList(key,val);
            return val;
        }
    }

    public void put(int key, int value) {
        if(map.size() < capacity){
            DNode node = new DNode(value);
            map.put(key,node);
            updateRecentList(key,value);
        }else if(map.size() == capacity){
            DNode node = map.get(key);
            updateRecentList(key,value);
        }else{
            System.out.println("Exceed capacity!");
        }
    }
    private void remove(int key){
        DNode node = map.get(key);
        if( node == null) return;
        else{
            removeNode(node);
            map.remove(key);
        }
    }
    private void updateRecentList(int key,int value){
        if(map.get(key) == null){
            DNode node = new DNode(value);
            DNode newnode = addFirst(node);
            map.put(key,newnode);
        }else{
            DNode node = map.get(key);
            removeNode(node);
            DNode newnode = addFirst(node);
            map.put(key,newnode);
        }
    }
    private DNode addFirst(DNode node){
        node.next = lhead.next;
        node.prev = lhead;
        lhead.next = node;
        return node;
    }
    private void removeNode(DNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node = null;
    }

    public static void main(String[] args) {
        String s = s.substring()
    }
}
