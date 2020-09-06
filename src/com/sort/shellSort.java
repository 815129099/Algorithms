package com.sort;

public class shellSort {

    /** 希尔排序，缩小增量排序
     *
     */
    public static int[] sort(int[] arr){
        SortUtil.showStartTime("shellSort.sort");
        int num = arr.length;
        //当前要插入的数
        int current,index=0;
        //增量
        int gap = 1;
        while (gap<num){
            gap = gap*3+1;
        }

        while (gap>=1){
            for(int i=gap;i<num;i++){
                current = arr[i];
                index = i-gap;
                while (index>=0 && arr[index]>current){
                    arr[index+gap] = arr[index];
                    index-=gap;
                }
                arr[index+gap] = current;
            }
            gap=gap/3;
        }


        SortUtil.showEndTime();
        return arr;
    }




    public static void main(String[] args) {
        System.out.println("-------------------------"+10000+"----------------------------------");
        sort(SortUtil.getArray(10000000));
        char[] num = "adads".toCharArray();
    }
}
