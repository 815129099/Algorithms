package com.sort.offer;

public class Code2 {
    public static String replaceSpace(StringBuffer str) {
        StringBuffer s = new StringBuffer();
        int length = str.length();
        for(int i=0;i<length;i++){
            if(str.charAt(i)==32){
                s.append("%20");
            }else{
                s.append(str.charAt(i));
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("hello world")));
    }
}
