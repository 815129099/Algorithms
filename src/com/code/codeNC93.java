package com.code;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

public class codeNC93 {
    public int[] LRU (int[][] operators, int k) {
        int size = operators.length;
        int num = 0;
        int[] arr = new int[size];
        HashMap<Integer,Integer> map = new HashMap();
        Queue<Integer> queue = new LinkedList();
        int key,value;
        for(int i=0;i<size;i++){
            if(operators[i][0]==1){
                key = operators[i][1];
                value = operators[i][2];
                map.put(key,value);
                //队列的操作
                if(queue.contains(key)){
                    //如果队列已存在该key
                    queue.remove(key);
                    queue.offer(key);
                }else if(queue.size()<k){
                    //队列不存在该key,且队列不满
                    queue.offer(key);
                }else{
                    //队列不存在该KEY，且空间已满
                    queue.poll();
                    queue.offer(key);
                }
            }else{
                //查询操作
                key = operators[i][1];
                if(!queue.contains(key)){
                    arr[num++] = -1;
                }else{
                    arr[num++] = map.get(key);
                    queue.remove(key);
                    queue.offer(key);
                }
            }
        }
        HashMap m = new LinkedHashMap();

        return java.util.Arrays.copyOf(arr,num);
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        int[] num = new codeNC93().LRU(arr,3);
    }
}
