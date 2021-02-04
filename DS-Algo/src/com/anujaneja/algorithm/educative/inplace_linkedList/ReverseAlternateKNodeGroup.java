package com.anujaneja.algorithm.educative.inplace_linkedList;

import com.anujaneja.algorithm.commons.ListNode;

import java.util.List;

public class ReverseAlternateKNodeGroup {

    public static ListNode reversealternateKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k<=1) {
            return head;
        }

        int cnt =1;

        ListNode lastHeadNode = head;
        ListNode curr=head;
        ListNode pre=null;

        //reverse k nodes
        while(curr!=null && cnt<=k) {
            ListNode temp=curr.next;
            curr.next = pre;
            pre=curr;
            curr=temp;
            cnt++;
        }

        //update old head next with next current pointer
        lastHeadNode.next = curr;

        //skip k-1 nodes...
        curr = skipNodes(curr,k-1);

//        System.out.println("curr="+curr);
        //Update lastHeadNode.next with k+1 Node...

        if(curr!=null && curr.next!=null) {
            //update current next with head of reversed sublist...
            curr.next= reversealternateKGroup(curr.next,k);
        }

        return pre;
    }

    private static ListNode skipNodes(ListNode curr, int k) {

        while(curr!=null && k-->0) {
            curr=curr.next;
        }

        return curr;
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

        ListNode result = reversealternateKGroup(head, 2);
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

        result = reversealternateKGroup(head, 2);
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

        result = reversealternateKGroup(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        System.out.println("\n-----------------------------------------");

        //single nodes...only
        head = new ListNode(1);

        result = reversealternateKGroup(head, 2);
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

        result = reversealternateKGroup(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }
}
