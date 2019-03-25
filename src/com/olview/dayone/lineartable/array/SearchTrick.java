package com.olview.dayone.lineartable.array;

public class SearchTrick { //一个数组中后一个数与前一个数差的绝对值是1，求一个值第一次出现的位置

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
