package com.olview.dayone.lineartable.array;

import java.util.Arrays;

public class SortBySelect { //选择排序
    public static void main(String[] args) {
        int[] testArray = new int[]{3,5,2,4,1};
        int[] sortArray = new SortBySelect().sortBySelect(testArray);
        System.out.println(Arrays.toString(sortArray));
    }

    public int[] sortBySelect(int[] array){
        int smallNum ;
        for(int j = 0; j < array.length-1 ;j++){
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
