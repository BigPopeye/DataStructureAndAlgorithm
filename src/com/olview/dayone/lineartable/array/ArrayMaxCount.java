package com.olview.dayone.lineartable.array;

public class ArrayMaxCount { //找出数组中断最大值
    public static void main(String[] args) {
        int[] testFindMaxCount = new int[]{3, 3, 4, 4, 2, 2, 2, 2, 6, 6, 6, 7,7, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int maxCounNum = new ArrayMaxCount().findMaxCount(testFindMaxCount);
        System.out.println(maxCounNum);

    }

    public int findMaxCount(int[] array) {
        int maxCount = 0;
        int maxIndex = 0;

        int currCount = 1;

        for (int i = 1; i < array.length - 1; i++) {
            if (array[i + 1] == array[i]) {
                currCount++;
            } else {
                if (currCount > maxCount) {
                    maxCount = currCount;
                    maxIndex = i;
                }
                currCount = 1;
            }
        }
        if (currCount>maxCount){
            maxCount = currCount;
            maxIndex = array.length-1;
        }

        System.out.println(maxIndex);
        System.out.println(maxCount);
        return array[maxIndex];
    }
}
