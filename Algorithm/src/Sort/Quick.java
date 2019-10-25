package Sort;

public class Quick {
    /** pseudocode
     * 1. Divide by choosing any element(->pivot) in the subarray array[p..r].
     *    Rearrange the element in array[p..r] so that all element in array[p..r]
     *    that are less than or equal to the pivot are to its left and all element
     *    that are greater than the pivot are to its right.
     *    this procedure is partitioning.
     * 2. Conquer by recursively sorting the subarrays array[p..q-1] and array[q+1..r]
     *
     */
    public static void main(String[] args) {
        int[] a = new int[]{7,-3,51,20,-9,42,6,89,17,24};
        Quick qikSort = new Quick();
        qikSort.sort(a,0,a.length-1);
        Print print = new Print();
        print.printArray(a);

    }


    /** go over the list and divide the list in to two part by the pivot, and return the pivot index.*/
    private int partition(int[] array,int p,int r){
        //Group S <= array[pivot],index from p...q-1;
        //Group L > array[pivot], index from q...j-1;
        //Group U uncompared,index from j...r-1;

        //Choose rightest one r to be the pivot
        //each step ,compare array[j],
        // if array[j] < array[pivot], swap array[j]and array[q],and add j and q by 1
        // otherwise, just add j by 1
        int q = p;
        for(int j = p ;j < r; j++){
            if(array[j] < array[r]){
                swap(array,j,q);
                q++;
            }
        }
        swap(array,r,q);
        return q;

    }

    public void sort(int[] array, int p, int r){
        if (p < r){
            int q = partition(array,p,r);
            sort(array,p,q-1);
            sort(array,q+1,r);
        }
    }

    // # 2. First used in Selection Sort
    private void swap(int[] array,int idxa, int idxb){
        int temp = array[idxa];
        array[idxa] = array[idxb];
        array[idxb] = temp;
    }
}
