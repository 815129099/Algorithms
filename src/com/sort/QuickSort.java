package com.sort;

import java.util.Arrays;

public class QuickSort {

    /** 快速排序
     *Arrays.sort
     * 数组长度小于47 插入排序
     */
    public static int[] sort(int[] arr){
        SortUtil.showStartTime("QuickSort.sort");
        int num = arr.length;
        quickSort(arr,0,num-1);
        SortUtil.showEndTime();
        return arr;
    }
    private static int[] quickSort(int[] arr,int left,int right){
        if(left<right){
            int p = partition(arr,left,right);
            quickSort(arr,left,p-1);
            quickSort(arr,p+1,right);
        }
        return arr;
    }
    /**
     *版本一：
     * 1、选定基准，一般认为第一个为基准
     * 记录左边大于基准的下标
     * 记录右边小于基准的下标，然后交换
     */
    private static int partition(int[] arr,int left,int right){
        int l = left;
        int r = right+1;
        int pivot = arr[left];//基准
        int temp;

        while (true){
            while (arr[++l]<pivot)
                if(l==right)
                    break;
            while (arr[--r]>pivot)
                if(r==left)
                    break;
            if(l>=r)
                break;
            //否则交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }

        temp = arr[r];
        arr[r] = arr[left];
        arr[left] = temp;
        return r;
    }


    public static int[] sort1(int[] arr){
        SortUtil.showStartTime("QuickSort.sort");
        int num = arr.length;
        quickSort1(arr,0,num-1);
        SortUtil.showEndTime();
        return arr;
    }
    private static int[] quickSort1(int[] arr,int left,int right){
        if(left<right){
            int p = partition1(arr,left,right);
            quickSort1(arr,left,p-1);
            quickSort1(arr,p+1,right);
        }
        return arr;
    }
    /**
     *版本二：
     * 选定基准，一般认为第一个为基准
     * 从右边开始寻找小于基准的下标，然后赋值给左边的下标
     * 再从左边开始寻找大于基准的值，然后赋值给右边的下标
     */
    private static int partition1(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int pivot = arr[left];//基准

        while (l<r){
            while (l<r && arr[r]>pivot) r--;
            if(l<r){
                arr[l] = arr[r];
                l++;
            }

            while (l<r && arr[l]<pivot) l++;
            if(l<r){
                arr[r] = arr[l];
                r--;
            }
        }
        arr[l] = pivot;
        return l;
    }


    public static int[] sort2(int[] arr){
        SortUtil.showStartTime("QuickSort.sort");
        int num = arr.length;
        quickSort2(arr,0,num-1);
        SortUtil.showEndTime();
        return arr;
    }
    private static int[] quickSort2(int[] arr,int left,int right){
        if(left<right){
            int p = partition2(arr,left,right);
            quickSort2(arr,left,p-1);
            quickSort2(arr,p+1,right);
        }
        return arr;
    }
    /**
     *版本三：
     * 选定基准，一般认为第一个为基准
     * 再选定一个小于基准的值得下标，默认基准后面第一个
     * 从左边开始遍历数组，如果值小于基准
     * 则该值与下标交换，下标++
     * 最后返回下标-1
     */
    private static int partition2(int[] arr,int left,int right){
        int pivot = left;//基准
        int index = pivot+1;
        int temp;

        for(int i=index;i<=right;i++){
            if(arr[i]<arr[pivot]){
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
        temp = arr[index-1];
        arr[index-1] = arr[pivot];
        arr[pivot] = temp;
        return index-1;
    }


    public static int[] sort3(int[] arr){
        SortUtil.showStartTime("QuickSort.sort");
        int num = arr.length;
        quickSort3(arr,0,num-1);
        SortUtil.showEndTime();
        return arr;
    }
    private static int[] quickSort3(int[] arr,int left,int right){
        if(right-left<7){
            InsertSort.sort(arr,left,right);
        }else if(right-left>7){
            int p = partition3(arr,left,right);
            quickSort3(arr,left,p-1);
            quickSort3(arr,p+1,right);
        }
        return arr;
    }
    /**
     *版本三：
     * 选定基准，一般认为第一个为基准
     * 再选定一个小于基准的值得下标，默认基准后面第一个
     * 从左边开始遍历数组，如果值小于基准
     * 则该值与下标交换，下标++
     * 最后返回下标-1
     */
    private static int partition3(int[] arr,int left,int right){

        int pivot = left;//基准
        int index = pivot+1;
        int temp;

        for(int i=index;i<=right;i++){
            if(arr[i]<arr[pivot]){
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
        temp = arr[index-1];
        arr[index-1] = arr[pivot];
        arr[pivot] = temp;
        return index-1;
    }

    public static void main(String[] args) {
        "Arrays.sort();".toCharArray();
        String s=null;
        s+='2';
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1");
        stringBuilder.toString();
        int[] num = SortUtil.getArray(10000000);

        int[] num1 = Arrays.copyOfRange(num,0,num.length);
        int[] num2 = Arrays.copyOfRange(num,0,num.length);
        int[] num3 = Arrays.copyOfRange(num,0,num.length);
        sort(num);
        System.out.println("-------------------------"+10000+"----------------------------------");
        sort1(num1);
        System.out.println("-------------------------"+10000+"----------------------------------");
        sort2(num2);
        System.out.println("-------------------------"+10000+"----------------------------------");
        sort3(num3);
    }
}
