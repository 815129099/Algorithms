package com.sort;

public class SelectSort {

    /** 原始选择排序
     * 每一次遍历选出一个最大值放到最后，或者选择一个最小值放到最前面
     */
    public static int[] sort(int[] arr){
        SortUtil.showStartTime("SelectSort.sort");
        int temp;
        int index;
        int num = arr.length;
        for (int i=0;i<num;i++){
            index = i;
            for(int j=i+1;j<num;j++){
                if(arr[j]<arr[index]){
                    index = j;
                }
            }
            if(index!=i){
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        SortUtil.showEndTime();
        return arr;
    }


    /**
     * 改进-：
     *每一次遍历选出一个最小值和一个最大值
     *分别放到最前面和最后面
     *
     */
    public static int[] wellSort(int[] arr){
        SortUtil.showStartTime("SelectSort.wellSort");
        int temp;
        int num = arr.length;
        int min = 0,max = 0;
        int startIndex=0,endIndex=num-1;
        //循环num/2次即可，因为每次选出两个值
        for (int i=0;i<num/2;i++){
            min = i;
            max = i;
            for(int j=startIndex;j<endIndex;j++){
                if(arr[j]<arr[min]){
                    //最下值赋给startIndex
                    min = j;
                }
                if(arr[j]>arr[max]){
                    //最大值赋给endIndex
                    max = j;
                }
            }
            if(startIndex!=min){
                temp = arr[min];
                arr[min] = arr[startIndex];
                arr[startIndex] = temp;
            }
            startIndex++;

            if(endIndex!=max){
                temp = arr[max];
                arr[max] = arr[endIndex];
                arr[endIndex] = temp;
            }
            endIndex--;

        }
        SortUtil.showEndTime();
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("-------------------------"+10000+"----------------------------------");
        SortUtil.show(sort(SortUtil.getArray(50000)));
        System.out.println("-------------------------"+10000+"----------------------------------");
        SortUtil.show(wellSort(SortUtil.getArray(50000)));

    }
}
