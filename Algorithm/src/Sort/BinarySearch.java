package Sort;

import java.util.Arrays;

public class BinarySearch {
    /** pseudo-code
     * 0. Sort the array first.
     * 1. let min = 0,max = length -1
     * 2. if max < min, then stop: target is not in the array.Return -1;
     * 3. Compute guess as average of min and max, rounded down(to the nearest integer)
     * 4. if array[guess] equals target, then stop. Found index is guess, Return Guess.
     * 5. if array[guess] < target, then set min = guess + 1;
     * 6. otherwise, set max = guess -1.
     * 7. go back to step 2
     */
    public static void main(String[] args) {
        int[] array = new int[]{5,12,-1,33,9,76,35,20,8};
        int target = 5;
        Arrays.sort(array);
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.binarySearch(array,target));

    }
    public int binarySearch(int[] arr,int target){
        int min = 0,max = arr.length-1;
        int guess;
        while (min < max){
            guess = (min + max) / 2;
            if(arr[guess] == target){
                return guess;
            }else if(arr[guess] < target){
                min = guess + 1;
            }else{
                max = guess -1;
            }
        }
        return -1;
    }
}
