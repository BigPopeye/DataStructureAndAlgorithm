package Sort;

public class Insertion {
    /** pseudocode
     * 1. insert the element starts at index 1 into the sorted subarray in index 0;
     * 2. insert the element starts at index 2 into the sorted subarray in indices 0 throuth 1;
     * 3. insert the element starts at index 3 into the sorted subarray in indices 0 throuth 2;
     * 4. ...
     * 5. Finally, insert the element starts at index n-1 into the sorted subarray in indices 0 through n-2.
     *
     * to implement, need additional function
     * insert(array,index) insert the element at index into the sorted array
     *
     */
    public static void main(String[] args) {
        int[] a = new int[]{7,-3,51,20,-9,42,6,89,17,24};
        Insertion insSort = new Insertion();
        insSort.sort(a);
        Print print = new Print();
        print.printArray(a);
    }

    private void insert(int[] array, int rightIndex){
        int temp = array[rightIndex];
        int i; //insert Index
        for(i = rightIndex - 1;i >=0 && array[i]>temp; i--){
            array[i+1] = array[i];
        }
        array[i+1] = temp;
    }
    public void sort(int[] array){
        for(int i = 1; i < array.length; i++){
            insert(array,i);
        }
    }

}
