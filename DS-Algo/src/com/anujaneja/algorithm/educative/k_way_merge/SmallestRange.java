package com.anujaneja.algorithm.educative.k_way_merge;

import java.util.*;

class SmallestRange {

    public static int[] findSmallestRange(List<Integer[]> lists) {
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>(
                (n1, n2) -> lists.get(n1.arrayIndex)[n1.elementIndex] - lists.get(n2.arrayIndex)[n2.elementIndex]);

        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;
        int currentMaxNumber = Integer.MIN_VALUE;

        for (int i = 0; i < lists.size(); i++) {
            minHeap.add(new Node(0, i));
            currentMaxNumber = Math.max(currentMaxNumber, lists.get(i)[0]);
        }

        while (minHeap.size() == lists.size()) {
            Node node = minHeap.poll();

            if((rangeEnd-rangeStart) >currentMaxNumber-lists.get(node.arrayIndex)[node.elementIndex]) {
                rangeStart = lists.get(node.arrayIndex)[node.elementIndex];
                rangeEnd = currentMaxNumber;
            }

            node.elementIndex++;

            //still has elements to be inserted...
            if(lists.get(node.arrayIndex).length>node.elementIndex) {
                minHeap.offer(node);
                currentMaxNumber = Math.max(currentMaxNumber,lists.get(node.arrayIndex)[node.elementIndex]);
            }
        }

        return new int[] { rangeStart, rangeEnd };
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 1, 5, 8 };
        Integer[] l2 = new Integer[] { 4, 12 };
        Integer[] l3 = new Integer[] { 7, 8, 10 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int[] result = SmallestRange.findSmallestRange(lists);
        System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
    }
}