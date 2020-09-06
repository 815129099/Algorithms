package com.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityQueue<Item> {
    private Item[] a;
    private int head;
    private int tail;
    private int N;

    public FixedCapacityQueue(int cap){
        a = (Item[]) new Object[cap];
    }

    public int size(){
        return N;
    }

    public void enqueue(Item e){
        if(tail==a.length){
            tail = 0;
        }
        if(head==tail&& N>0){
            resize(a.length*2);
        }
        a[tail++] = e;
        N++;
    }

    public Item dequeue(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = a[head];
        a[head] = null;
        head++;
        if(head==a.length){
            head=0;
        }
        N--;
        if(N>0 &&N==a.length/4){
            resize(a.length/2);
        }
        return item;
    }

    public boolean isEmpty(){
        return head==tail;
    }

    private void resize(int newCap){
        Item[] items = (Item[]) new Object[newCap];
        for(int i=0;i<N;i++){
            // items[i] = a[head++];  head会出现越界的现象
            items[i] = a[(head+i)%a.length];
        }
        a = items;
        head = 0;
        tail = N;
    }

    public Iterator iterator(){
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        private int i = 0;
        private int j = N;

        @Override
        public boolean hasNext() {
            return N>i;
        }

        @Override
        public Item next() {
            Item item = a[i+head%a.length];
            i++;
            return item;
        }
    }




}
