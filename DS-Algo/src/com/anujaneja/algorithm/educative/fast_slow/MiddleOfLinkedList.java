package com.anujaneja.algorithm.educative.fast_slow;

import com.anujaneja.algorithm.commons.ListNode;

/**
 * Easy - https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfLinkedList {

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        //Test Case 1: Odd
        ListNode root = new ListNode(1);
        //        root=null;
        root.next = new ListNode(2);
        root.next.next= new ListNode(3);
        root.next.next.next = (new ListNode(4));
        root.next.next.next.next= new ListNode(5);
        ListNode node = middleNode(root);
        int expected = 3;
        System.out.println("middleElement="+(node.val==expected));

        //Test Case 2: Even
        root = new ListNode(1);
        //        root=null;
        root.next = new ListNode(2);
        root.next.next= new ListNode(3);
        root.next.next.next = (new ListNode(4));
        root.next.next.next.next= new ListNode(5);
        root.next.next.next.next.next= new ListNode(6);
        node = middleNode(root);
        expected = 4;
        System.out.println("middleElement="+(node.val==expected));

        //Test Case 3: null
        root = null;
        node = middleNode(root);
        expected = 0;
        System.out.println("middleElement="+(node!=null ? node.val==expected:0));
        //Test Case 4: Single Element
        root = new ListNode(1);

        node = middleNode(root);
        expected = 1;
        System.out.println("middleElement="+(node.val==expected));
    }
}
