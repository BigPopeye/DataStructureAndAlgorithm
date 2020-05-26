public class LRUCache{
    private Dictionary<int, DNode> _map;
    private DNode _dummyHead;
    private Node _dummyTail;
    private class DNode{ // double LinkedList
        int value;
        DNode prev;
        DNode next;
        private DNode(int val){
            value = val;
            prev = null;
            next = null;
        }
    }
    public int capacity;
    private int size;

    public LRUCache(int defaultSize) {
        this.capacity = defaultSize;
        _size = 0;
        _map = new Dictionary<int, DNode>();
        _dummyHead = new DNode(-1);
        _dummyTail = new DNode(-1);
        _dummyHead.next = _dummyTail;
        _dummyTail.prev = _dummyHead;
    }

    public int get(int key) {
        if(_map.ContainsKey(key)){
            DNode node = _map[key];
            removeNode(node);
            addToFirst(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if(_map.ContainsKey(key)){
            DNode node = _map[key];
            node.value = value;
            removeNode(node);
            addToFirst(node);
        }else{
            if(_size == capacity){
                map.Remove(_dummyTail.prev.key);
                removeNode(_dummyTail.prev);
                _size--;
            }
            DNode newNode = new DNode(key, value);
            _map.Add(key,newNode);
            addToFirst(newNode);
            _size++;
        }
    }

    private void addToFirst(DNode node){
        node.next = _dummyHead.next;
        node.prev = _dummyHead;
        _dummyHead.next.prev = node;
        _dummyHead.next = node;
    }
    private void removeNode(DNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}