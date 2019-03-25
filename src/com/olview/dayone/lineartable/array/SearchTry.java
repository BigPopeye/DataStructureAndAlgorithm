package com.olview.dayone.lineartable.array;

public class SearchTry {// 二分查找：分别使用递归和非递归方式
    public static void main(String[] args) {
        int testNum = 16;
        int[] testArray = new int[]{5, 9, 12, 13, 16, 22};
        int searchNumIndex = new SearchTry().searchNumByLoop(testArray, testNum);
        System.out.println(searchNumIndex);
    }

    public int searchNumTry(int[] array, int num) {
        return searchNumTry(array, num, 0, array.length - 1);
    }

    public int searchNumTry(int[] array, int num, int startOffset, int endOffset) {
        if (startOffset > endOffset) {
            return -1;
        }
        int middleOffset = (startOffset + endOffset) / 2;// note
        if (array[middleOffset] == num) {
            return middleOffset;
        } else if (array[middleOffset] > num) {
            return searchNumTry(array, num, startOffset, middleOffset - 1);
        } else {
            return searchNumTry(array, num, middleOffset + 1, endOffset);
        }
    }


    public int searchNumByLoop(int[] array, int num) {
        int startOffset = 0;
        int endOffset = array.length - 1;
        int midOffset = (startOffset + endOffset) / 2;
        while (num != array[midOffset] && startOffset <= endOffset) {
            if (num < array[midOffset]) {
                endOffset = midOffset - 1;
            } else {
                startOffset = midOffset + 1;
            }
            midOffset = (startOffset + endOffset) / 2;
        }
        if (num == array[midOffset]) {
            return midOffset;
        } else {
            return -1;
        }
    }

    public int searchNumByLoopUsingDoWhile(int[] array, int num) {
        int startOffset = 0;
        int endOffset = array.length - 1;

        do {
            int midOffset = (startOffset + endOffset) / 2;
            if (num < array[midOffset]) {
                endOffset = midOffset - 1;
            } else if(num > array[midOffset]){
                startOffset = midOffset + 1;
            } else {
                return midOffset;
            }
        } while (startOffset <= endOffset);
        return -1;
    }
}
