package com.stack;

import java.util.Iterator;
import java.util.Queue;

public class FixedCapacityQueueTest {
    public static void main(String[] args) {
        /*
        FixedCapacityQueue queue = new FixedCapacityQueue(5);
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(2);
        queue.enqueue(22);
        queue.enqueue(33);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(2);
        queue.enqueue(9);
        queue.dequeue();*/

        FixedCapacityQueue queue = new FixedCapacityQueue(10);
        for(int i = 0;i<10;i++){
            queue.enqueue(i);

        }
        Iterator iterator = queue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
