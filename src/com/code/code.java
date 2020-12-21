package com.code;

import java.util.*;

public class code {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n+1];
        for(int i=1; i<=n; i++){
            num[i] = in.nextInt();
        }
        int K = in.nextInt();
        int D = in.nextInt();
        long[][] dpm = new long[K+1][n+1];//dpm[i][j]表示选中了i个人，以第j个人结尾的能力最大乘积
        long[][] dpn = new long[K+1][n+1];//dpn[i][j]表示选中了i个人，以第j个人结尾的能力最小乘积
        for(int j=1; j<n+1; j++){//初始
            dpm[1][j] = num[j];
            dpn[1][j] = num[j];
        }
        for(int i=1; i<K+1; i++){//初始
            dpm[i][1] = num[1];
            dpn[i][1] = num[1];
        }
        for(int i=2;i<K+1;i++){
            for(int j=2;j<n+1;j++){
                for(int k=Math.max(1,j-D);k<j;k++){
                    dpm[i][j] = Math.max(dpm[i][j],Math.max(dpm[i-1][k]*num[j],dpn[i-1][k]*num[j]));
                    dpn[i][j] = Math.min(dpn[i][j],Math.min(dpm[i-1][k]*num[j],dpn[i-1][k]*num[j]));
                }
            }
        }
        long max = Math.max(dpm[K][1],dpn[K][1]);
        for(int j=2;j<n+1;j++){
            max = Math.max(Math.max(dpm[K][j],dpn[K][j]),max);
        }
        System.out.println(max);
    }
}