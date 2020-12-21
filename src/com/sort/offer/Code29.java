package com.sort.offer;
/*
*输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Code29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        int length = input.length;
        ArrayList<Integer> arr = new ArrayList(k);
        if(length==0 || k==0 ||k>length)
            return arr;
        for(int i=0;i<k;i++){
            if(i==0){
                arr.add(input[i]);
            }else{
                insertSort(arr,i+1,input[i],0);
            }
        }

        for(int j=k;j<length;j++){
            if(input[j]<arr.get(k-1)){
                insertSort(arr,k,input[j],1);
            }
        }
        return arr;
    }

    public void insertSort(ArrayList<Integer> arr,int k,int key,int flag){
        if(flag==0){
            arr.add(k-1,key);
        }else {
            arr.set(k-1,key);
        }
        int i=k-2;
        while(i>=0 && arr.get(i)>key){
            arr.set(i+1,arr.get(i));
            i--;
        }
        arr.set(i+1,key);
    }

    public int Sum_Solution(int n) {
        boolean sum = n>1 && (n+=Sum_Solution(n-1))>0;
        return n;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> arrayList = new Code29().GetLeastNumbers_Solution(arr,4);
        for (int k:arrayList) {
            System.out.print(k+",");
        }
    }
}
