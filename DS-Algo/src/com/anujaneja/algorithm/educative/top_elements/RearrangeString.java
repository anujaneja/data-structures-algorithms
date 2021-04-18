package com.anujaneja.algorithm.educative.top_elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Medium - https://leetcode.com/problems/reorganize-string/
 * NICE SOLUTION -  https://leetcode.com/problems/reorganize-string/discuss/232469/Java-No-Sort-O(N)-0ms-beat-100
 *
 */
class RearrangeString {

    public static String rearrangeString(String str) {
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        Map<Character, Integer> charFreqMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
        }

        maxHeap.addAll(charFreqMap.entrySet());
        StringBuilder resultBuilder = new StringBuilder();
        Map.Entry<Character,Integer> preEntry = null;
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character,Integer> currEntry = maxHeap.poll();

            if(preEntry!=null && preEntry.getValue()>0) {
                maxHeap.offer(preEntry);
            }

            resultBuilder.append(currEntry.getKey());

            currEntry.setValue(currEntry.getValue()-1);
            preEntry = currEntry;

        }

        return resultBuilder.toString().length()==str.length()?resultBuilder.toString():"";
    }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }
}