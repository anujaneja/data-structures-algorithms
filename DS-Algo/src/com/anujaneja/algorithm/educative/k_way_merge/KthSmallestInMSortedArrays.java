package com.anujaneja.algorithm.educative.k_way_merge;

import java.util.*;

class Node {
    int arrayIndex;
    int elementIndex;

    Node(int elementIndex, int arrayIndex) {
        this.elementIndex = elementIndex;
        this.arrayIndex = arrayIndex;
    }
}

/**
 * Similar
 * Medium - https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 */
class KthSmallestInMSortedArrays {

    public static int findKthSmallest(List<Integer[]> lists, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((o1, o2) -> lists.get(o1.arrayIndex)[o1.elementIndex] - lists.get(o2.arrayIndex)[o2.elementIndex]);

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                minHeap.offer(new Node(0, i));
            }
        }

        int numberCount = 0;
        int result = 0;

        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();

            result = lists.get(node.arrayIndex)[node.elementIndex];
            numberCount++;
            node.elementIndex++;

            if(numberCount==k) {
                break;
            }

            //Just incremented element index... arrayIndex remains...
            if(node.elementIndex<lists.get(node.arrayIndex).length) {
                minHeap.offer(node);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
