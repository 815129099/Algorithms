package com.sort.offer;

import java.util.ArrayList;

//输入一个链表，输出该链表中倒数第k个结点。
public class Code10 {
    public static ListNode FindKthToTail(ListNode head,int k) {
        ArrayList<ListNode> arr = new ArrayList<>();
        while(head!=null){
            arr.add(head);
            head = head.next;
        }
        return arr.get(arr.size()-k);
    }
//快指针先往前走k步，注意判断边界，然后快慢一起走，当快指针为none的时候，慢指针走到了倒数第k个节点
    public static ListNode FindKthToTail1(ListNode head,int k){
        if(k==0){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        int i=1;
        while(i<k){
            if(null!=fast&&null!=fast.next){
                fast = fast.next;
            }else {
                return null;
            }
            i++;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        node.next = node1;
        System.out.print(FindKthToTail1(node,5));
    }
}
