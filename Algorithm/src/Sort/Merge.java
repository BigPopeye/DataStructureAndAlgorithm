package Sort;

public class Merge {
    /** divide-and-conquer sort
     * pseudocode
     * 1. Divide by finding the number q of the position midway between p and r.
     *    (Do this step the same way the midpoint in binary search)
     * 2. Conquer by recursively sorting the subarrays in each of the two subproblems created by the divide step.
     * 3. Combine by merging the two sorted subarrays back into the single sorted subarray[p...r]
     *
     * to implement, need  additional merge function to merge,
     * and use recurse to do the divide part.
     */
    public static void main(String[] args) {
        int[] a = new int[]{7,-3,51,20,-9,42,6,89,17,24};
        Merge merSort = new Merge();
        merSort.sort(a,0,a.length-1);
        Print print = new Print();
        print.printArray(a);

    }

    public static void merge(int[] array,int startIndex, int midIndex,int endIndex){
        /**merge subarray1 from startIndex to midIndex, and subarray2 from (midIndex + 1) to endIndex
         * in the original array.
         */

        int p = startIndex; //sort pointer

        // assign array values to temp array
        int lowlength = midIndex - startIndex +1;
        int highlength = endIndex - midIndex;

        int[] lowHalf = new int[lowlength];
        int[] highHalf = new int[highlength];
        for(int k = 0; k < lowlength;k++,p++){
            lowHalf[k] = array[p];
        }
        for(int k = 0;k < highlength; k++,p++){
            highHalf[k] = array[p];
        }

        // assgin temp array values back to the array
        int i = 0;
        int j = 0;
        p = startIndex;
        while(i < lowlength && j < highlength){
            if(lowHalf[i] < highHalf[j]){
                array[p++] = lowHalf[i++];
            }else{
                array[p++] = highHalf[j++];
            }
        }
        // assgin left values from the unsigned part to the array
        while(i < lowlength){
            array[p++] = lowHalf[i++];
        }
        while (j < highlength){
            array[p++] = highHalf[j++];
        }
    }

    public static void sort(int[] array, int p, int r){
        if(p < r){
            int q = (p + r)/2;
            sort(array,p,q);
            sort(array,q+1,r);
            merge(array,p,q,r);
        }
    }

}
