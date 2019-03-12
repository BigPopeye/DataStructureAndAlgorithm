import java.util.Arrays;

public class SortBySelect {
    public static void main(String[] args) {
        int[] testArray = new int[]{3,5,2,4,1};
        int[] sortArray = new SortBySelect().sortBySelect(testArray);
        System.out.println(Arrays.toString(sortArray));
    }

    public int[] sortBySelect(int[] array){
        int smallNum = 0;
        for(int j = 0; j < array.length-1 ;j++){
            smallNum = array[j];
            for(int i = j+1;i < array.length; i ++){
                if (array[i] < array[j]) {
                    smallNum = array[i];
                    array[i] = array[j];
                    array[j] = smallNum;
                }
            }
        }
        return array;
    }
}
