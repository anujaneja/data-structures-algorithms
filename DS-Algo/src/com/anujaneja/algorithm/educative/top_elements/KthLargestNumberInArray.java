package com.anujaneja.algorithm.educative.top_elements;

import java.util.PriorityQueue;

public class KthLargestNumberInArray {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1,o2)->o1-o2);

        for(int i=0;i<k;i++) {
            minHeap.offer(nums[i]);
        }

        for(int i=k;i<nums.length;i++) {
            if(nums[i]>minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int result = KthLargestNumberInArray.findKthLargest(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth largest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = KthLargestNumberInArray.findKthLargest(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth largest number is: " + result);

        result = KthLargestNumberInArray.findKthLargest(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);
    }
}
