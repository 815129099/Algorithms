package com.sort.offer;

import java.util.Arrays;
import java.util.Stack;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Code44 {
    public String ReverseSentence(String str) {
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        if(length==0){
            return null;
        }
        char ch;
        for(int i=0;i<length;i++){
            ch = str.charAt(i);
            if(ch!=32){
                sb.append(str.charAt(i));
            }else{
                stack.push(sb.toString());
                sb.setLength(0);
            }
        }
        if(sb.length()!=0){
            stack.push(sb.toString());
            sb.setLength(0);
        }
        int size = stack.size();
        for(int i=0;i<size;i++){
            if(i==size-1){
                sb.append(stack.pop());
            }else{
                sb.append(stack.pop()).append(" ");
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        new Code44().ReverseSentence("i am a student");
    }
}
