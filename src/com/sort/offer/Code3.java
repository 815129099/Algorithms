package com.sort.offer;

import java.util.ArrayList;

public class Code3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(null==listNode){
            return null;
        }
        ArrayList<Integer> array = new ArrayList();
        int index = 0;
        array.add(0,new Integer(listNode.val));
        while(listNode.next!=null){
            index++;
            listNode = listNode.next;
            array.add(0,new Integer(listNode.val));
        }
        return array;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(5);
        listNode2.next = listNode3;
        listNode1.next = listNode2;
        listNode.next = listNode1;
        ArrayList<Integer> arrayList = new Code3().printListFromTailToHead(null);
    }
}
