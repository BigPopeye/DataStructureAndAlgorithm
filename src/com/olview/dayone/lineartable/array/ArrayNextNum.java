package com.olview.dayone.lineartable.array;

public class ArrayNextNum {
    public static void main(String[] args) {
        int[] testFindNextNum = new int[]{1, 2, 5, 9, 8, 6};
        int nextNum = new ArrayNextNum().findNextNum(testFindNextNum);
        System.out.println(nextNum);
    }

    public int findNextNum(int[] array) {
        int nextNum = 0;
        int maxNum = 0;
        for (int index:array) {
            if (array[index] > maxNum) {
                maxNum = array[index];
            } else if (array[index] > nextNum) {
                nextNum = array[index];
            }
        }
        return nextNum;
    }
}
