package com.anujaneja.algorithm.educative.fast_slow;

import com.anujaneja.algorithm.commons.ListNode;

public class ReverseLinkedList {

    public static ListNode reverse(ListNode head) {
        if(head==null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while( fast!=null) {
            ListNode temp = fast.next;
            fast.next=slow;

            //move forward...
            slow = fast;
            fast=temp;
        }

        if(head.next!=null) {
            head.next=null;
        }

        head=slow;

        return head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
//                root=null;
        root.next = new ListNode(2);
        root.next.next= new ListNode(3);
        root.next.next.next = (new ListNode(4));
        root.next.next.next.next= new ListNode(5);

        root = reverse(root);

        System.out.println(root!=null?root.printLinkedList():null);


    }
}
