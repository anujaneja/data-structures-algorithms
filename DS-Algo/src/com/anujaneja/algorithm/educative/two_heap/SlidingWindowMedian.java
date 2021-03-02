package com.anujaneja.algorithm.educative.two_heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result  = new double[nums.length-k+1];

        for(int i=0;i<nums.length;i++) {
            if(maxHeap.isEmpty() || maxHeap.peek()>=nums[i]) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }

            rebalanceHeaps();

            if(i+1>=k) {
                if(maxHeap.size()==minHeap.size()) {
                    //or index....
                    result[i-k+1] = maxHeap.peek()/2.0+minHeap.peek()/2.0;
                } else {
                    result[i-k+1] = maxHeap.peek();
                }


                //remove the extra element
                int elementTobeRemoved = nums[i-k+1];

                if(elementTobeRemoved<=maxHeap.peek()) {
                    maxHeap.remove(elementTobeRemoved);
                } else {
                    minHeap.remove(elementTobeRemoved);
                }

                rebalanceHeaps();
            }

        }

        return result;
    }

    public void rebalanceHeaps() {
        if(maxHeap.size()>minHeap.size()+1) {
            minHeap.add(maxHeap.poll());
        } else if(minHeap.size()>maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.medianSlidingWindow(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.medianSlidingWindow(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }

}
