package com.anujaneja.algorithm.educative.fast_slow;

import com.anujaneja.algorithm.commons.ListNode;

public class LinkedListPalindrome {

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next==null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        int counter =1;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            counter++;
        }

        ListNode mid = slow;

        System.out.println("mid="+mid.val);
        System.out.println("counter="+counter);
        ListNode secondHalf = ReverseLinkedList.reverse(mid);

        ListNode startNode = head;

        boolean isPalindrome = true;
        //Only two element present...
        if(secondHalf==null && head.val!=mid.val) {
            isPalindrome = false;
        }
        ListNode secondHalfItr = secondHalf;

        while (secondHalfItr!= null) {
            if (secondHalfItr.val != startNode.val) {
                isPalindrome = false;
                break;
            } else {
                secondHalfItr = secondHalfItr.next;
                startNode = startNode.next;
            }
        }

        secondHalf = ReverseLinkedList.reverse(secondHalf);

//        mid.next = secondHalf;

        return isPalindrome;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        //                root=null;
        root.next = new ListNode(2);
//        root.next.next = new ListNode(2);
//        root.next.next.next = (new ListNode(1));
//        root.next.next.next.next = new ListNode(1);
//        root.next.next.next.next.next = new ListNode(3);

        System.out.println("isPalindrome=" + isPalindrome(root));

        System.out.println(root.printLinkedList());

    }
}

