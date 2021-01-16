package com.anujaneja.algorithm.educative.fast_slow;

import com.anujaneja.algorithm.commons.ListNode;

/**
 * Medium - https://leetcode.com/problems/reorder-list/
 */
public class RearrangeLinkedList {

    public static void reorderList(ListNode head) {
        if(head==null || head.next==null) {
            return;
        }

        ListNode slow=head;
        ListNode fast = head;

        //find middle point of linkedlist...
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode mid=slow;

//        System.out.println(mid.val);

        mid=ReverseLinkedList.reverse(mid);

//        System.out.println(mid.val);

        ListNode start = head;

        while(mid!=null) {
//            System.out.println(mid.val);
            ListNode temp1 = start.next;
            ListNode temp2 = mid.next;

            start.next=mid;
            mid.next=temp1;
            //move forward both pointers...
            start=temp1;
            mid=temp2;
        }

        if(start!=null) {
            start.next=null;
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        //                root=null;
        root.next = new ListNode(2);
//                root.next.next = new ListNode(3);
//                root.next.next.next = (new ListNode(4));
//                root.next.next.next.next = new ListNode(5);
//                root.next.next.next.next.next = new ListNode(6);
        reorderList(root);
        System.out.println(root.printLinkedList());
    }

}
