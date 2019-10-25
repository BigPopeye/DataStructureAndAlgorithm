package Sort;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args)
    {
        int[] arr = {-5, -10, 0, -3, 8, 5, -1, 10};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void countSort(int[] arr, int R, int min){

        int n = arr.length;
        int output[] = new int[n];
        int i;
        int count[] = new int[R];
        //Arrays.fill(count,0);

        for(i = 0; i < n; i++){
            count[ arr[i] - min ] ++;
        }

        /**Change count[i] so that count[i] now contains actual position of this digit in output[]*/
        for(i = 1; i < R; i++){
            count[i] += count[i-1];
        }

        /**Build output array to arr[]*/
        for(i = n-1; i>=0;i--){
            output[-- count[arr[i] - min]] = arr[i];
        }
        for(i = 0; i < n; i++){
            arr[i] = output[i];
        }

    }

    public static void countSort(int[] arr){
        int n = arr.length;
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min +1;
        countSort(arr,range,min);
    }
}
