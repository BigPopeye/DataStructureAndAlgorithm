package SortModule;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick {
    public static final int M = 10;  // when sort small array, use insertion sort.
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0, a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo + M){
            Insertion.sort(a,lo,hi);
            return;
        }
//        if(hi <=lo){
//            return;
//        }
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static int partition(Comparable[] a, int lo, int hi){
        // divided a into a[lo]...a[i-1] and a[i+1]...a[hi]
        int i = lo, j = hi+1;
        Comparable v = a[lo];
        while(true){
            while(less(a[++i],v)){
                if(i == hi) break;
            }
            while(less(v,a[--j])){
                if(j == lo) break;
            }
            if(i >= j){
                break;
            }
            swap(a,i,j);
        }
        swap(a,lo,j);
        return j;
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void swap(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
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
            if (less(a[i], a[i-1]))
                return false;
        return true;
    }
    public static void main(String[] args){
        // 从标准输入读取字符串，将它们排序并输出
        String[] a = new String[]{"hello","world","!","good","morning","teacher"};
        //Integer[] a = new Integer[]{33,66,28,71,47};
        sort(a);
        assert isSorted(a) : "unsorted array!";
        show(a);
    }
}
