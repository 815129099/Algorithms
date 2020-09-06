package com.stack;

import java.util.Iterator;

public class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;
    public FixedCapacityStack(int cap){
        a = (Item[])new Object[cap];
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void push(Item e){
        if(N==a.length){
            resize(a.length*2);
        }
        a[N++] = e;
    }

    public Item pop(){
        Item item = a[--N];
        a[N] = null;//避免对象游离，及时被回收
        if(N>0 && N==a.length/4){
            resize(a.length/2);
        }
        return item;
    }

    private void resize(int newCap){
        Item[] items = (Item[]) new Object[newCap];
        for(int i=0;i<N;i++){
            items[i] = a[i];
        }
        a = items;
    }



    private class ReverseArrayIterator implements Iterator<Item>{
        private int i = N;

        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }

    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }
}
