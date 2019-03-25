package com.olview.dayone.lineartable.array;

import java.util.Arrays;

public class SortByInsert {
    public static void main(String[] args) {
        int[] testArray = new int[]{3, 5, 2, 4, 1};
        int[] sortArray = new SortByInsert().sortByInsert(testArray);
        System.out.println(Arrays.toString(sortArray));
    }
//
//    public int[] sortByInsert(int[] array){
//        int selectValue = 0;
//        for(int i = 1; i <= array.length-1 ;i++){
//            selectValue = array[i];
//            for(int j = i- 1;j >= 0; j --){
//                if (array[j] > selectValue) {
//                    array[j+1] = array[j];
//                }else if((j+1)!=i){
//                    array[j+1] = selectValue;
//                    break;
//                }
//                if(j==0&&(j+1)!=i){
//                    array[j] =  selectValue;
//                }
//            }
//        }
//        return array;
//    }

    public int[] sortByInsert(int[] array) {
        int selectValue ;
        for (int i = 1; i <= array.length - 1; i++) {
            selectValue = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > selectValue) {
                    array[j + 1] = array[j];
                    array[j] = selectValue;
                } else {
                    break;
                }
            }
        }
        return array;
    }

}
