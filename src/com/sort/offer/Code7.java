package com.sort.offer;

/**
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 */
public class Code7 {
    public static int NumberOf1(int n) {
        int num = 0;
        if(n==0){
            return 0;
        }else if(n>0){
            while(n!=0){
                if(n%2==1){
                    num++;
                }
                n=n/2;
            }
        }else{

        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(0));
    }
}
