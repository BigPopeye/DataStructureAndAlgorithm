public class ArrayTry {
    public static void main(String[] args) {
        int[] testFindMaxNum = new int[]{1,5,3,9,5};
        int maxNum = new ArrayTry().findMaxNum(testFindMaxNum);
        System.out.println(maxNum);
    }

    public int findMaxNum(int[] array) {
        int maxNum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxNum) {
                maxNum = array[i];
            }
        }
        return maxNum;
    }

}
