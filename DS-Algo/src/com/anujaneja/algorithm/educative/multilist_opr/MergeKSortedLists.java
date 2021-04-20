package com.anujaneja.algorithm.educative.multilist_opr;

import java.util.*;

class ListNode {
    int      value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

/**
 * Easy - https://leetcode.com/problems/merge-k-sorted-lists/
 */
class MergeKSortedLists {

    public static ListNode merge(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        ListNode resultHead = null;
        ListNode resultTail = null;

        for (ListNode root : lists) {
            if (root != null) {
                minHeap.offer(root);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();

            if (resultHead == null) {
                resultHead = node;
                resultTail = resultHead;
            } else {
                resultTail.next = node;
                resultTail = resultTail.next;
            }

            if(node.next!=null) {
                minHeap.offer(node.next);
            }

        }

        return resultHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = MergeKSortedLists.merge(new ListNode[] { l1, l2, l3 });
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}

