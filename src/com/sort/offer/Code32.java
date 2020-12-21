package com.sort.offer;

import java.util.Stack;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Code32 {
    Stack<Integer> s1= new Stack();
    Stack<Integer> s2= new Stack();
    public String PrintMinNumber(int [] numbers) {
        int num = numbers.length;
        quickSort3(numbers,0,num-1);
        StringBuffer str = new StringBuffer();
        for(int i:numbers){
            str=str.append(i);
        }
        return str.toString();
    }

    public int[] quickSort3(int[] arr,int left,int right){
        int p = partition3(arr,left,right);
        quickSort3(arr,left,p-1);
        quickSort3(arr,p+1,right);
        return arr;
    }


    public int partition3(int[] arr,int left,int right){
        int pivot = left;//基准
        int index = pivot+1;
        int temp;
        for(int i=index;i<=right;i++){
            if(!isMax(arr[i],arr[pivot])){
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

    public boolean isMax(int l,int r){
        s1.removeAllElements();
        s2.removeAllElements();
        while(l>9){
            s1.push(l%10);
            l=l/10;
        }
        s1.push(l);

        while(r>9){
            s2.push(r%10);
            r = r/10;
        }
        s2.push(r);

        while(!s1.empty() && !s2.empty()){
            if(s1.pop()>s2.pop()){
                return true;
            }
        }
        if(s1.empty()&&!s2.empty()){
            return false;
        }else if(!s1.empty()&&s2.empty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3,32,321};
    }
}
