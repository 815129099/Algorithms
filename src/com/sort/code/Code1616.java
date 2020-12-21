package com.sort.code;

public class Code1616 {
    public static int[] subSort(int[] array) {
        if(array.length<=1){
            int[] num = {-1,-1};
            return num;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int first = -1;
        int last = -1;
        int length = array.length;
        for(int i=0;i<length;i++){
            if(array[i]<max){
                last = i;
            }else {
                max = Math.max(array[i],max);
            }

            if(array[length-1-i]>min){
                first = length-1-i;
            }else {
                min = Math.min(min,array[length-1-i]);
            }
        }
        int[] num = {first,last};
        return num;
    }

    public static void main(String[] args) {
        int[] num = {1,3,9,7,5};
        int[] newNum = subSort(num);
        for (int i:newNum) {
            System.out.print(i+",");
        }
    }
}
