package com.sort.offer;

import java.util.Stack;

/**
 * ]输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class Code14 {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0){
            return true;
        }
        int length = pushA.length;
        Stack<Integer> stack = new Stack<>();
        int i=0,j=0;
        while(j<length){
            if(stack.empty() || stack.peek()!=popA[j]){
                if(i==length){
                    return false;
                }else {
                    stack.push(pushA[i++]);
                }
            }else{
                if(stack.peek()==popA[j]){
                    stack.pop();
                    j++;
                }
            }

        }
        if(i==length&&j==length){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] arr1 = {4,3,5,1,2};
        System.out.print(IsPopOrder(arr,arr1));
    }
}
