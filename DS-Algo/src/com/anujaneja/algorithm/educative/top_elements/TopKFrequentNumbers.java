package com.anujaneja.algorithm.educative.top_elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Medium - https://leetcode.com/problems/top-k-frequent-elements/
 */
class TopKFrequentNumbers {

    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        List<Integer> topNumbers = new ArrayList<>(k);
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) -> o1.getValue() - o2.getValue());
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:freqMap.entrySet()) {
            minHeap.offer(entry);

            if(minHeap.size()>k) {
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            topNumbers.add(minHeap.poll().getKey());
        }

        return topNumbers;
    }

    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}
