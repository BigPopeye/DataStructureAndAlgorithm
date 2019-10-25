package Sort;

public class Selection {
    /** pseudocode
     * 1. Find the smallest card. Swap it with the first card
     * 2. Find the second-smallest card. Swap it with the second card.
     * 3. Find the third-smallest card. Swap it with the third card.
     * 4. repeat finding the next-smallest card, and swapping it into the correct position until the array is sorted.
     *
     * to implement, two function needed:
     * 1. find the index of the minimum element in a subarray,return index;
     * 2. swap it with the current index
     */
    public static void main(String[] args) {
        int[] a = new int[]{7,-3,51,20,-9,42,6,89,17,24};
        Selection selSort = new Selection();
        selSort.sort(a);
        Print print = new Print();
        print.printArray(a);
    }

    public void sort(int[] array){
        for(int i = 0; i < array.length; i++){
            swap(array,i,indexOfMimimum(array,i));
        }
    }

    private void swap(int[] array,int start, int min){
        int temp = array[start];
        array[start] = array[min];
        array[min] = temp;
    }

    private int indexOfMimimum(int[] array,int startIndex){
        int minValue = array[startIndex];
        int minIndex = startIndex;

        for(int i = minIndex; i < array.length; i++){
            if(array[i] < minValue){
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }


/*   public void sort(int[] array){
       for(int i = 0; i< array.length;i++){
           int minValue = array[i];
           int minIndex = i;
           for(int j = i+1; j < array.length; j++){
               if(array[j] < minValue){
                   minIndex = j;
                   minValue = array[j];
               }
           }
           swap(array,i,minIndex);
       }
   }*/ // two for loops to do the same thing


    public static int indexOfMimimum(String[] array, int startIndex){
        int smallest = startIndex;
        for(int i = startIndex; i< array.length; i++){
            int cmp = array[i].compareTo(array[smallest]);
            if(cmp < 0){
                smallest = i;
            }
        }
        return smallest;
    }

}
