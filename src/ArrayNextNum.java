public class ArrayNextNum {
    public static void main(String[] args) {
        int[] testFindNextNum = new int[]{1, 2, 5, 9, 8, 6};
        int nextNum = new ArrayNextNum().findNextNum(testFindNextNum);
        System.out.println(nextNum);
    }

    public int findNextNum(int[] array) {
        int nextNum = 0;
        int maxNum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxNum) {
                maxNum = array[i];
            } else if (array[i] > nextNum) {
                nextNum = array[i];
            }
        }
        return nextNum;
    }
}
