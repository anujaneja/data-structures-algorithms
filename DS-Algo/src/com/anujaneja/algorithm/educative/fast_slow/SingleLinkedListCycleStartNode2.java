package com.anujaneja.algorithm.educative.fast_slow;

import com.anujaneja.algorithm.commons.ListNode;

/**
 * Medium - https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class SingleLinkedListCycleStartNode2 {

    public static ListNode detectCycle(ListNode root) {
        if(root==null) {
            return null;
        }

        ListNode slow = root;
        ListNode fast = root;

        while(slow!=null && fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast) {
                //System.out.println(slow.val);
                slow = root;
                while(fast!=slow) {
                    fast=fast.next;
                    slow=slow.next;
                    // System.out.println(slow.toString()+fast.toString());
                }

                //System.out.println(fast.val);
                return fast;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        //        root=null;
        root.next = new ListNode(2);
        root.next.next= new ListNode(3);
        root.next.next.next = (new ListNode(4));
        root.next.next.next.next= new ListNode(5);
        root.next.next.next.next.next= root.next;

        System.out.println("isCyclePresent="+detectCycle(root));
    }

}
