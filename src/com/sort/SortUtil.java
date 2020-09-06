package com.sort;

public class SortUtil {
    private static long startTime;
    private static long endTime;

    public static int[] getArray(int n){
        int[] arr = new int[n];
        //获取n个10000以内的随机数
        for (int i=0;i<n;i++){
            arr[i] = (int)(Math.random()*1000000);
        }
        return arr;
    }


    public static int[] getSortArray(int n){
        int[] arr = new int[n];
        //获取n个有序数
        for (int i=0;i<n;i++){
            arr[i] = i;
        }
        return arr;
    }

    public static void showStartTime(String str){
        System.out.println("-------------------"+str+"-----------------------");
        startTime = System.currentTimeMillis();
        System.out.println("startTime:"+startTime);
    }

    public static void showEndTime(){
        endTime = System.currentTimeMillis();
        System.out.println("endTime:"+endTime);
        System.out.println("totalTime:"+(endTime-startTime));

    }

    public static void show(int[] arr){
        for (int i:arr) {
            System.out.print(i+",");
        }
    }
}
