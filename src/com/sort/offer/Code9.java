package com.sort.offer;

import java.util.ArrayList;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Code9 {
    public static void reOrderArray(int [] array) {
        int length = array.length;
        if(length==0){
            return;
        }
        int temp;
        int index=0;
        for(int i=0;i<length;i++){
            if(array[i]%2==1){
                if(index!=i){
                    temp = array[i];
                    int j = i-1;
                    while(j>=index){
                        array[j+1] = array[j];
                        j--;
                    }
                    array[j+1] = temp;
                }
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,1,3,5,7};
        int[] arr1 = {1,2,3,4,5,6,7,8};
        reOrderArray(arr);
        for (int i:arr) {
            System.out.print(i+",");
        }
    }
}
