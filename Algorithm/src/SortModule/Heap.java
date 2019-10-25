package SortModule;

import edu.princeton.cs.algs4.StdOut;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Heap {
    public static void sort(Comparable[] a){
        int N = a.length;
        for(int k = N/2; k>=1;k--){ // 将任意数组构造成一个大顶堆,
            sink(a, k, N);
        }
        while (N>1){ // 下沉排序
            swap(a,1,N--);
            sink(a,1, N);
        }
    }
    private static void swap(Comparable[] a, int i, int j){
        while(i < j){
            Comparable t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }
    private static void sink(Comparable[] a, int k, int N)
    {
        //int N = a.length;
        while (2*k <= N)
        {
            int j = 2*k;
            if (j < N && less(a[j],a[j+1])) j++;
            if (!less(a[k], a[j])) break;
            swap(a,k, j);
            k = j;
        }
    }
    private static void swim(Comparable[] a, int k){
        int N = a.length;
        while(k >1 && less(a[k/2],a[k])){
            swap(a,k/2,k);
            k = k/2;
        }
    }
    private static boolean less(Comparable v, Comparable m){
        return v.compareTo(m) < 0;
    }
    private static void show(Comparable[] a) { // 在单行中打印数组
        for (int i = 0; i < a.length; i++){
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
    public static boolean isSorted(Comparable[] a) {
        // 测试数组元素是否有序
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])){
                return false;
            }

        return true;
    }
    public static void main(String[] args){
        // 从标准输入读取字符串，将它们排序并输出
        String[] a = new String[]{"hello","world","!","good","morning","teacher"};
        //Integer[] a = new Integer[]{33,66,28,71,47};
        sort(a);
        assert isSorted(a) : "unsorted array!";
        show(a);
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();

    }
}
