package lineartable;

/* Version : v1.0 from <Algorithm 4th>
 * Date : August 6, 2019
 */

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq; // 基于堆堆完全二叉树
    private int N = 0; //PQ中元素的数量，数据存储于pq[1...N]中，pq[0]没有使用

    /** public **/
    public MaxPQ(int n){
        pq = (Key[]) new Comparable[n + 1];
        //pq[1] = Integer.MAX_VALUE;
    }

    // 插入操作不超过 lgN + 1 次比较
    public void insert(Key val){
        pq[++N] = val;
        swim(N); // 往队尾插入数据，并swim到对应的
    }
    // 删除操作不超过 2lgN 次比较
    public Key delMax(){
        Key max = pq[1];
        pq[1] = pq[N];
        pq[N+1] = null; // 注意将下一个置为null, 防止对象游离
        sink(1);
        return max;
    }

    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N == 0;
    }

    public Key getMax(){
        return pq[1];
    }

    /** private **/
    private void sink(int k){
        while(k*2 <= N){
            int j = k*2;
            if(j < N && less(pq[j],pq[j+1])) j++;
            if(!less(pq[k],pq[j])) break;
            swap(pq,k,j);
            k = j;
        }
    }
    private void swim(int k){
        while(k>1 && less(pq[k/2],pq[k])){
            swap(pq,k/2,k);
            k = k/2;
        }
    }
    private boolean less(Comparable v, Comparable u){
        return v.compareTo(u) < 0;
    }

    private void swap(Comparable[] a, int i, int j){
        Comparable c = a[i];
        a[i] = a[j];
        a[j] = c;
    }
}
