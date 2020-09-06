package com.sort;

public class InsertSort {

    /** 原始插入排序
     * 默认第一个有序，每次选中一个数，插入到前面已经有序的排列中
     */
    public static int[] sort(int[] arr){
        SortUtil.showStartTime("InsertSort.sort");
        for (int i = 1; i < arr.length; i++) {

            // 记录要插入的数据
            int tmp = arr[i];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }

        }
        SortUtil.showEndTime();
        return arr;
    }


    public static int[] sort(int[] arr,int left,int right){
        for (int i = left+1; i < right+1; i++) {
            // 记录要插入的数据
            int temp = arr[i];
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = temp;
            }

        }
        return arr;
    }

    /**
     * 改进-：
     *当把一个数插入到前面已经有序的数列中时，从后往前一个一个的比显然不是最好的方法
     *可以使用二分查找，二分查找可以较为快速的从有序的数列中找到合适的位置，
     * 然后把该位置之后的数组后移，把该数放到合适的位置
     */
    public static int[] wellSort(int[] arr){
        SortUtil.showStartTime("InsertSort.wellSort");
        int num = arr.length;
        //当前要插入的数
        int current;
        int left=0,right=0,mid=0;
        for (int i=1;i<num;i++){
            current = arr[i];
            left = 0;right = i-1;
            //找出合适的插入位置
            while (left<=right){
                mid = left+((right-left)>>1);
                if(current<arr[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            //合适位置及其之后的值向后平移
            for(int k=i-1;k>=left;k--){
                arr[k+1] = arr[k];
            }

            arr[left] = current;
        }
        SortUtil.showEndTime();
        return arr;
    }



    public static void main(String[] args) {
        System.out.println("-------------------------"+10000+"----------------------------------");
        SortUtil.show(sort(SortUtil.getArray(2<<17)));
        SortUtil.show(sort(SortUtil.getArray(2<<17),0,10));
        System.out.println("-------------------------"+10000+"----------------------------------");
        SortUtil.show(wellSort(SortUtil.getArray(2<<17)));

    }
}
