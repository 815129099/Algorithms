package com.stack;

import java.util.Iterator;

public class FixedCapacityStackTest {
    public static void main(String[] args) {
        /*
        FixedCapacityStack FixedCapacityStack = new FixedCapacityStack(5);
        FixedCapacityStack.push(1);
        FixedCapacityStack.push(2);
        System.out.println(FixedCapacityStack.size()+"isEmpty:"+FixedCapacityStack.isEmpty());

        FixedCapacityStack.push("3");
        FixedCapacityStack.push(3);
        System.out.println(FixedCapacityStack.pop());*/

        FixedCapacityStack FixedCapacityStack = new FixedCapacityStack(10);
        for(int i=0;i<10;i++){
            FixedCapacityStack.push(i);
        }

        Iterator iterator = FixedCapacityStack.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
