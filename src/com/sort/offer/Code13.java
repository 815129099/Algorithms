package com.sort.offer;

import java.util.Stack;

//定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
public class Code13 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if(minStack.empty()){
            minStack.push(node);
        }else{
            if(minStack.peek()>node){
                minStack.push(node);
            }else{
                minStack.push(minStack.peek());
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Code13 code13 = new Code13();
        code13.push(3);
        System.out.println(code13.min());
        code13.push(4);
        System.out.println(code13.min());
        code13.push(2);
        System.out.println(code13.min());
        code13.push(3);
        System.out.println(code13.min());
        code13.pop();
        System.out.println(code13.min());
        code13.pop();
        System.out.println(code13.min());
        code13.pop();
        System.out.println(code13.min());
        code13.push(0);
        System.out.println(code13.min());

    }
}
