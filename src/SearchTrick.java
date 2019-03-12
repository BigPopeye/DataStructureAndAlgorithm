public class SearchTrick {

    public static void main(String[] args) {
        int[] testArray = new int[]{3, 4, 3, 2, 3, 4, 5, 6, 5, 4, 5, 6, 7, 8, 7};
        int testNum = 7;
        int testIndex = new SearchTrick().searchTrickOne(testArray, testNum);
        System.out.println(testIndex);
    }

    public int searchTrickOne(int[] array, int num) {
        int targetNumIndex = 0;
        while (num != array[targetNumIndex]) {
            targetNumIndex += Math.abs(num - array[targetNumIndex]);
        }
        return targetNumIndex;
    }
}
