package com.anujaneja.algorithm.educative.inplace_linkedList;

import com.anujaneja.algorithm.commons.ListNode;


public class ReverseKNodeGroupEducative {

    public static ListNode reverseKGroup(ListNode head, int k) {
//        int length = findLength(head);
//        System.out.println(length);

        if(head==null || head.next==null || k<=1) {
            return head;
        }

        int cnt =1;

        ListNode lastHeadNode = head;
        ListNode curr=head;
        ListNode pre=null;

        while(curr!=null && cnt<=k) {
            ListNode temp=curr.next;
            curr.next = pre;
            pre=curr;
            curr=temp;
            cnt++;
        }

        //Update lastHeadNode.next with k+1 Node...

        if(curr!=null) {
            lastHeadNode.next=reverseKGroup(curr,k);
        }

        return pre;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = reverseKGroup(head, 2);
        System.out.println("Nodes of the reversed LinkedList are: ");
        int i=8;
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        System.out.println("\n-----------------------------------------");

        //Two nodes...only
        head = new ListNode(1);
        head.next = new ListNode(2);

        result = reverseKGroup(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }


        System.out.println("\n-----------------------------------------");


        //4 nodes...only
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        result = reverseKGroup(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        System.out.println("\n-----------------------------------------");

        //single nodes...only
        head = new ListNode(1);

        result = reverseKGroup(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        System.out.println("\n-----------------------------------------");

        //Basic case... with less nodes at last to be reversed...
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        result = reverseKGroup(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }

}
