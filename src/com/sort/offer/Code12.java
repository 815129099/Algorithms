package com.sort.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Code12 {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix.length==0 || matrix[0].length==0){
            return null;
        }
        int endL = matrix[0].length-1;
        int startL = 0;
        int endH = matrix.length-1;
        int startH = 0;
        int i,j,k,l;
        int hh=0,ll=0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(endH!=startH && endL!=startL){
            i = startL;
            while(i<=endL) arr.add(matrix[startH][i++]);
            hh++;
            startH++;
            if(endH==startH || endL==startL) break;
            j = startH;

            while(j<=endH) arr.add(matrix[j++][endL]);
            ll++;
            endL--;
            if(endH==startH || endL==startL) break;
            k = endL;

            while(k>=startL) arr.add(matrix[endH][k--]);
            hh++;
            endH--;
            if(endH==startH || endL==startL) break;
            j = endH;

            while(j>=startH) arr.add(matrix[j--][startL]);
            ll++;
            startL++;
        }

        while(endH==startH){
            while(startL<=endL){
                if(hh%2==1){
                    arr.add(matrix[endH][endL--]);
                }else {
                    arr.add(matrix[endH][startL++]);
                }
            }
            startH++;
        }
        while(endL==startL){
            while(startH<=endH){
                if(ll%2==1){
                    arr.add(matrix[endH--][startL]);
                }else {
                    arr.add(matrix[startH++][startL]);
                }
            }
            startL++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2},{3,4},{5,6},{7,8},{9,10}};
        ArrayList<Integer> arrayList = printMatrix(arr);
        for (Integer i:arrayList) {
            System.out.print(i+",");
        }
    }
}
