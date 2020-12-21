package com.sort;

import java.util.Arrays;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        sort(nums1);
        sort(nums2);
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] num = new int[Math.min(n1,n2)];
        int index=0,j=0,i=0;

        while(i<n1&&j<n2){
            if(nums1[i]>nums2[j]){
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else{
                if(index==0 || nums1[i]!=num[index-1]){
                    num[index++] = nums1[i];
                }
                i++;j++;
            }

        }
        return Arrays.copyOfRange(num,0,index);
        //return num;
    }

    public void sort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }

    public void quickSort(int[] arr,int left,int right){
        if(right-left<=7){
            insertSort(arr,left,right);
        }else if(right-left>7){
            int p = partition(arr,left,right);
            quickSort(arr,left,p-1);
            quickSort(arr,p+1,right);
        }
    }

    public int partition(int[] arr,int left,int right){
        int pivot = left;
        int index = pivot+1;
        int temp;
        double n = 0;
        for(int i=index;i<=right;i++){
            if(arr[i]<arr[pivot]){
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
        temp = arr[pivot];
        arr[pivot] = arr[index-1];
        arr[index-1] = temp;
        return index-1;
    }

    public void insertSort(int[] arr,int left,int right){
        for(int i=left+1;i<=right;i++){
            int temp = arr[i];
            int j = i;
            while(j>0 && arr[j-1]>temp){
                arr[j] = arr[j-1];
                j--;
            }
            if(j!=i){
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = {4,9,5};
        int[] num2 = {9,4,9,8,4};
        int[] num3 = new Solution().intersection(num1,num2);

    }
}
