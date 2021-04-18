package com.anujaneja.algorithm.educative.top_elements;

import java.util.*;

class MaximumDistinctElements {

    public static int findMaximumDistinctElements(int[] nums, int k) {
        int maximumDistinctElementCount = 0;

        if (nums.length <= k) {
            return maximumDistinctElementCount;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(((o1, o2) -> o1.getValue() - o2.getValue()));
        minHeap.addAll(freqMap.entrySet());
//        System.out.println("freqMap=" + freqMap);
//        System.out.println("minHeap=" + minHeap);

        while (k > 0 && !minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = minHeap.poll();
//            System.out.println("number = " + entry.getKey());
            // System.out.println("value = "+entry.getValue());
            // System.out.println("k="+k);

            if (entry.getValue() == 1) {
                maximumDistinctElementCount++;
            } else if (entry.getValue() > 1) {

                k = k - (entry.getValue() - 1);
                if (k >= 0) {
                    maximumDistinctElementCount++;
                }
            }
        }

        // System.out.println("k="+k);

        //If k>0 means we need to remove some distinct elements as well...
        if (k > 0) {
            maximumDistinctElementCount = maximumDistinctElementCount - k;
        }

        return maximumDistinctElementCount;

    }

    public static void main(String[] args) {
        int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }
}
