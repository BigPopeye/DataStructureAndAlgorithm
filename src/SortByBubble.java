import java.util.Arrays;

public class SortByBubble {
    public static void main(String[] args) {
        int[] testArray = new int[]{3, 5, 2, 4, 1};
        int[] sortArray = new SortByBubble().sortByBubble(testArray);
        System.out.println(Arrays.toString(sortArray));
    }

    public int[] sortByBubble(int[] array) {
        int swap = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j+1] < array[j]) {
                    swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
        }
        return array;
    }
}
