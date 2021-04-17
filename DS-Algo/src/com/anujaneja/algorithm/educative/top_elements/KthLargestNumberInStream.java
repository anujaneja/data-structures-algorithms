package com.anujaneja.algorithm.educative.top_elements;

import java.util.*;

/**
 * Easy -  https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
class KthLargestNumberInStream {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
    private final int k;

    public KthLargestNumberInStream(int[] nums, int k) {
        this.k=k;

        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }

    public int add(int num) {
        minHeap.offer(num);

        if(minHeap.size()>k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}