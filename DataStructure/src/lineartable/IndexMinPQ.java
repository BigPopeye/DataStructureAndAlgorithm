package lineartable;

import java.util.NoSuchElementException;

/**  基于索引index的优先队列，应用场景有 多路已排序的源合并，合并后也是有序的**/
public class IndexMinPQ<Key extends Comparable<Key>> {
    private int[] pq; // 保存索引
    private int N = 0; //PQ中元素的数量，数据存储于pq[1...N]中，pq[0]没有使用
    private int maxN;

    private int[] qp; // PQ的逆序，qp[pq[i]] = pq[qp[i]] = i
    private Key[] keys; // 保存元素

    /** public **/
    public IndexMinPQ(int n){
        this.maxN = n;
        keys = (Key[]) new Comparable[n + 1];
        pq = new int[n + 1];
        qp = new int[n + 1];
        for (int i = 0; i <= n; i++){
            qp[i] = -1;
        }
    }

    // 插入操作不超过 lgN + 1 次比较
    public void insert(int k, Key val){
        if (k < 0 || k >= maxN) throw new IllegalArgumentException();
        if (contains(k)) throw new IllegalArgumentException("index is already in the priority queue");
        ++N;
        qp[k] = N;
        pq[N] = k;
        keys[k] = val;
        swim(N); // 往队尾插入数据，并swim到对应的位置
    }
    // 删除操作不超过 2lgN 次比较
    public int delMin(){
        if (N == 0) throw new NoSuchElementException("Priority queue underflow");
        int min = pq[1];
        swap(1, N--);
        sink(1);
        assert min == pq[N+1];
        qp[min] = -1;        // delete
        keys[min] = null;    // to help with garbage collection
        pq[N+1] = -1;        // not needed
        return min;
    }

    public Key getMin(){
        if(N == 0) throw new NoSuchElementException("Priority queue underflow!");
        return keys[pq[1]];
    }
    public int minIndex(){
        if(N == 0) throw new NoSuchElementException("Priority queue underflow!");
        return pq[1];
    }

    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N == 0;
    }

    public void changeKey(int k, Key key){
        if( k < 0 || k >= maxN) throw new IllegalArgumentException();
        if(!contains(k)) throw new NoSuchElementException("index is not in the queue");
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }
    public void delete(int k){
        int index = qp[k];
        swap(index,N--);
        swim(index);
        sink(index);
        qp[k] = -1;
        keys[k] = null;
        pq[N+1] = -1;
    }
    public boolean contains(int k){
        if( k < 0 || k >= maxN) throw new IllegalArgumentException();
        return qp[k] != -1;
    }
    /** private **/

    /***************************************************************************
     * Heap helper functions.
     ***************************************************************************/
    private void sink(int k){
        while(k*2 <= N){ // 需要有 =
            int j = k*2;
            if(j < N && greater(j,j+1)) j++; //注意！由于while有 = ，这里如果漏掉 j < N 就会出错
            if(!greater(k,j)) break;
            swap(k,j);
            k = j;
        }
    }
    private void swim(int k){
        while(k>1 && greater(k/2,k)){
                swap(k/2,k);
                k = k/2;
            }
    }

    /***************************************************************************
     * General helper functions.
     ***************************************************************************/
    private boolean greater(int i, int j){
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0; //小顶堆，与大顶堆的比较方向相反
    }

    private void swap(int i, int j){
        int s = pq[i];
        pq[i] = pq[j];
        pq[j] = s;
        //注意添加以下代码
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }
}
