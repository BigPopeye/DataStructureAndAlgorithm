package SortModule;

import edu.princeton.cs.algs4.StdOut;

public class Selection {
    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i = 0; i< N; i++){
            // insert a[i] into a[i-1], a[i-2],...
            int min = i;
            for(int j = i+1; j < N;j++){
                if(less(a[j],a[min])){
                    min = j;
                }
            }
            swap(a, i, min);
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
        //StdOut.println();
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
