package SortModule;

import edu.princeton.cs.algs4.StdOut;

public class Merge {
    private static Comparable[] aux;
    public static void sort(Comparable[] a){
        aux =  new Comparable[a.length];
        sort(a, 0, a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi){
        if(hi<=lo){
            return;
        }
        int mid = lo + (hi-lo)/2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a,lo, mid, hi);
    }
    public static void merge(Comparable[] a, int lo, int mid, int hi){
        int i = lo;
        int j = mid+1;
        for(int k = lo; k <=hi; k++){
            aux[k] = a[k];
        }
        for(int k = lo; k <= hi; k++){
            if(i > mid){
                a[k] = aux[j++];
            }else if(j > hi){
                a[k] = aux[i++];
            }else if(less(aux[j],aux[i])){
                a[k] = aux[j++];
            }else{
                a[k] = aux[i++];
            }
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
    }
}
