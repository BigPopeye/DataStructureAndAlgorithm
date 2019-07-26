package SortModule;

//import edu.princeton.cs.algs4.StdOut;

import edu.princeton.cs.algs4.StdOut;

public class Insertion {
    public static void sort(Comparable[] a){
        sort(a,0,a.length);
    }
    public static void sort(Comparable[] a, int lo, int hi){
        for(int i = lo; i< hi; i++){
            // insert a[i] into a[i-1], a[i-2],...
            for(int j = i; j > 0 && less(a[j],a[j-1]);j--){
                swap(a, j, j-1);
            }
        }
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
        //String[] a = new String[]{"hello","world","!","good","morning","teacher"};
        Integer[] a = new Integer[]{33,66,28,71,47};
        sort(a);
        assert isSorted(a) : "unsorted array!";
        show(a);
    }
}
