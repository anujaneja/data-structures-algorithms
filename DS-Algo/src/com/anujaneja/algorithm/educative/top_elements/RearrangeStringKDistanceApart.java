package com.anujaneja.algorithm.educative.top_elements;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class RearrangeStringKDistanceApart {

    public static String reorganizeString(String str, int k) {
        if (k <= 1) {
            return str;
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        maxHeap.addAll(freqMap.entrySet());
        StringBuilder resultBuilder = new StringBuilder(str.length());
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currEntry = maxHeap.poll();
            resultBuilder.append(currEntry.getKey());
            currEntry.setValue(currEntry.getValue() - 1);
            queue.add(currEntry);

            if (queue.size() < k) {
                continue;
            }

            Map.Entry<Character,Integer> entry = queue.poll();

            if (entry.getValue() > 0) {
                maxHeap.offer(entry);
            }
        }

        //        System.out.println("resultBuilder.toString()="+resultBuilder.toString());

        return resultBuilder.toString().length() == str.length() ? resultBuilder.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aab", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
    }
}
