package com.sort.offer;

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
 * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class Code67 {
    public int cutRope(int target) {
        if(target==2){
            return 1;
        }
        int max = target;
        int current = 0;
        int[] arr = new int[60];
        for(int i=2;i<target/2;i++){
            if(arr[target-i]>0){
                current = arr[target-i];
            }else{
                current = cutMax(target-i,arr);
            }
            if(max<i*current){
                max = i*current;
            }
        }
        return max;
    }

    public int cutMax(int target,int[] arr){
        if(target==2){
            return target;
        }
        int max = target;
        int current = 0;
        for(int i=2;i<=target/2;i++){
            if(arr[target-i]>0){
                current = arr[target-i];
            }else{
                current = cutMax(target-i,arr);
            }
            if(max<i*current){
                max = i*current;
            }
        }
        arr[target] = max;
        return max;
    }

    public static void main(String[] args) {
        System.out.print(new Code67().cutRope(15));
    }
}
