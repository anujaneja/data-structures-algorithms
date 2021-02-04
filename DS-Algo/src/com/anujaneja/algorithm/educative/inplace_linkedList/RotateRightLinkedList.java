package com.anujaneja.algorithm.educative.inplace_linkedList;

import com.anujaneja.algorithm.commons.ListNode;

public class RotateRightLinkedList {
    public static ListNode rotateRight(ListNode head, int k) {
        int len = findLength(head);
        //System.out.println("len="+len+" len%k="+k%len);
        //System.out.println("head="+head.val);

        if(head==null || head.next==null || k<1 || k%len==0) {
            return head;
        }

        ListNode oldHead =head;
        int i=1;
        int tailPosition = len- (k>len?(k%len):k);
        //System.out.println("tailPosition="+tailPosition);

        ListNode curr=head;
        ListNode newTail= null;
        ListNode newHead = null;

        while(curr.next!=null) {
            if(i==tailPosition) {
                newTail=curr;
                newHead=curr.next;
            }
            curr=curr.next;
            i++;
        }

        ListNode oldTail=curr;
        newTail.next=null;
        oldTail.next=head;

        return newHead;
    }

    public static int findLength(ListNode head) {
        ListNode curr=head;
        int length=0;

        while(curr!=null) {
            curr=curr.next;
            length++;
        }

        return length;

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
        int k=2;
        ListNode result = rotateRight(head, k);
        System.out.println("Nodes of the  rotated LinkedList by :"+k+" are: " );
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        System.out.println("\n-----------------------------------------");


        //Rotating by 1 
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        k=1;
        result = rotateRight(head, k);
        System.out.println("Nodes of the  rotated LinkedList by :"+k+" are: " );
        
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        System.out.println("\n-----------------------------------------");


        //Rotating by length
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        k=8;
        result = rotateRight(head, k);
        System.out.println("Nodes of the  rotated LinkedList by :"+k+" are: " );

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        System.out.println("\n-----------------------------------------");


        //Rotating by more than length...
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        k=20;
        result = rotateRight(head, k);
        System.out.println("Nodes of the  rotated LinkedList by :"+k+" are: " );

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        System.out.println("\n-----------------------------------------");



        //Rotating by 0 ...
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        k=0;
        result = rotateRight(head, k);
        System.out.println("Nodes of the  rotated LinkedList by :"+k+" are: " );

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        System.out.println("\n-----------------------------------------");
    }
}
