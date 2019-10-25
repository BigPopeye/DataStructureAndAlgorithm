package Sort;
import java.io.*;
import java.util.*;

public class RadixSort {
    public static void main (String[] args)
        {
            int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
            int n = arr.length;
            radixSort(arr);
            System.out.println(Arrays.toString(arr));

        }

    static int getMax(int arr[], int n){
        int max = arr[0];
        for(int i = 1;i<n;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    /** A function to do counting sort of arr[] according to the digit represented by exp*/
    static void countSort(int arr[], int exp){
        int n = arr.length;
        int output[] = new int[n];
        int i;
        int R = 10;
        int count[] = new int[R];
        //Arrays.fill(count,0);

        for(i = 0; i < n; i++){
            count[ (arr[i]/exp)% R ] ++;
        }

        /**Change count[i] so that count[i] now contains actual position of this digit in output[]*/
        for(i = 1; i < R; i++){
            count[i] += count[i-1];
        }

        /**Build output array to arr[]*/
        for(i = n-1; i>=0;i--){
            output[-- count[(arr[i]/exp)%R] ] = arr[i];
        }
        for(i = 0; i < n; i++){
            arr[i] = output[i];
        }
    }

    static void radixSort(int arr[]){
        int n = arr.length;
        int m = getMax(arr, n);
        for(int exp = 1; m/exp >0; exp *=10){
            countSort(arr,exp);
        }
    }
}
