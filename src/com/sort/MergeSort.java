package com.sort;

public class MergeSort {
    private static int[] newArr;

    /** 归并排序
     *
     */
    public static int[] sort(int[] arr){
        SortUtil.showStartTime("MergeSort.sort");
        newArr = new int[arr.length];
        sort(arr,0,arr.length-1);
        SortUtil.showEndTime();
        return arr;
    }
    private static void sort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int mid = left+((right-left)>>1);
        sort(arr,left,mid);
        sort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }
    private static void merge(int[] arr,int left,int mid,int right){
        int l = left,r = mid+1;

        for(int i=left;i<=right;i++){
            newArr[i] = arr[i];
        }

        for(int k=left;k<=right;k++){
            if(l>mid) arr[k] = newArr[r++];
            else if(r>right) arr[k] = newArr[l++];
            else if(newArr[r]<newArr[l]) arr[k] = newArr[r++];
            else arr[k] = newArr[l++];
        }

        /*
        int index = left;
        while (l<=mid && r<=right){
            if(newArr[l]<newArr[r]){
                arr[index++] = newArr[l++];
            }else{
                arr[index++] = newArr[r++];
            }
        }
        //如果左边数组未拷贝完，则继续
        while (l<=mid){
            arr[index++] = newArr[l++];
        }

        while (r<=right){
            arr[index++] = newArr[r++];
        }*/
    }

    /**
     * 优化一：对于小规模数组使用插入排序
     */
    public static int[] sort1(int[] arr){
        SortUtil.showStartTime("MergeSort.sort");
        newArr = new int[arr.length];
        sort1(arr,0,arr.length-1);
        SortUtil.showEndTime();
        return arr;
    }
    private static void sort1(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int mid = left+((right-left)>>1);
        sort1(arr,left,mid);
        sort1(arr,mid+1,right);
        merge1(arr,left,mid,right);
    }
    private static void merge1(int[] arr,int left,int mid,int right){
        int l = left,r = mid+1;

        for(int i=left;i<=right;i++){
            newArr[i] = arr[i];
        }

        if(right-left<=7){
            InsertSort.sort(arr,left,right);
        }else {
            for(int k=left;k<=right;k++){
                if(l>mid) arr[k] = newArr[r++];
                else if(r>right) arr[k] = newArr[l++];
                else if(newArr[r]<newArr[l]) arr[k] = newArr[r++];
                else arr[k] = newArr[l++];
            }
        }


    }

    /**
     * 优化二：如果arr[mid]<=arr[mid+1]时则认为数组已经有序
     * 则跳过merge
     */
    public static int[] sort2(int[] arr){
        SortUtil.showStartTime("MergeSort.sort");
        newArr = new int[arr.length];
        sort2(arr,0,arr.length-1);
        SortUtil.showEndTime();
        return arr;
    }
    private static void sort2(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int mid = left+((right-left)>>1);
        sort2(arr,left,mid);
        sort2(arr,mid+1,right);
        if(arr[mid]>arr[mid+1])
            merge1(arr,left,mid,right);
    }


    public static int[] sort3(int[] arr){
        SortUtil.showStartTime("MergeSort.sort");
        int num = arr.length;
        newArr = new int[num];

        for(int size=1;size<num;size=size+size){
            for(int index=0;index<num-size;index+=size+size){
                merge1(arr,index,index+size-1,Math.min(index+size+size-1,num-1));
            }
        }

        SortUtil.showEndTime();
        return arr;
    }


    public static void main(String[] args) {
        System.out.println("-------------------------"+10000+"----------------------------------");
        //SortUtil.show(sort1(SortUtil.getArray(10000)));
        sort(SortUtil.getArray(5000000));
        System.out.println("-------------------------"+1000000+"----------------------------------");
        sort1(SortUtil.getArray(5000000));
        System.out.println("-------------------------"+1000000+"----------------------------------");
        sort2(SortUtil.getArray(5000000));
        System.out.println("-------------------------"+1000000+"----------------------------------");
        sort3(SortUtil.getArray(5000000));
    }
}
