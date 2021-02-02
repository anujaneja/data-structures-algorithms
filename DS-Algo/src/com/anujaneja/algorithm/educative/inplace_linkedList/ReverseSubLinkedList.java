package com.anujaneja.algorithm.educative.inplace_linkedList;

import com.anujaneja.algorithm.commons.ListNode;

public class ReverseSubLinkedList {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(m<1 || head.next==null || head==null || m==n ) {
            return head;
        }

        int counter=1;
        ListNode curr=head;
        ListNode pre=null;

        //skip m-1 nodes...
        while(counter<m && curr!=null) {
            pre=curr;
            curr=curr.next;
            counter++;
        }

        //System.out.println("pre="+pre.val+" curr="+curr.val);

        //save sublist previous...
        ListNode sPre=pre;
        ListNode lastNodeOfSubList=curr;

        //start the reverse process...
        while(counter<=n && curr!=null) {
            ListNode temp = curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
            counter++;
        }

        //connect the first part
        if(sPre!=null) {
            ListNode temp = sPre.next;
            sPre.next = pre;
            temp.next = curr;
        } else {
            head=pre;
        }

        //connect the last part...
        lastNodeOfSubList.next = curr;


        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = reverseBetween(head, 3, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        System.out.println("\n----------------------------------");

        // middle reverse...
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        result = reverseBetween(head, 3, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        System.out.println("\n----------------------------------");

        // Start of list
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        result = reverseBetween(head, 1, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }


        System.out.println("\n----------------------------------");

        // Full reverse...
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        result = reverseBetween(head, 1, 5);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }


        System.out.println("\n----------------------------------");

        // With 1 element only...
        head = new ListNode(1);

        result = reverseBetween(head, 1, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }


        System.out.println("\n----------------------------------");

        // two elements only...
        head = new ListNode(1);
        head.next = new ListNode(2);

        result = reverseBetween(head, 1, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }


        System.out.println("\n----------------------------------");


        // p and q equals...
        head = new ListNode(1);
        head.next = new ListNode(2);

        result = reverseBetween(head, 1, 1);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
