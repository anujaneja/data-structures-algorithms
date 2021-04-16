package com.anujaneja.algorithm.educative.top_elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Medium - https://leetcode.com/problems/sort-characters-by-frequency/
 * Alternate solution - https://leetcode.com/problems/sort-characters-by-frequency/discuss/93420/Java-O(n)-Bucket-Sort-Solution-O(nlogm)-PriorityQueue-Solution-easy-to-understand
 */
class FrequencySort {

    public static String sortCharacterByFrequency(String S) {
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            freqMap.put(S.charAt(i), freqMap.getOrDefault(S.charAt(i), 0) + 1);
        }

        maxHeap.addAll(freqMap.entrySet());
        StringBuilder resultStr = new StringBuilder(S.length());

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();

            for (int i = 0; i < entry.getValue(); i++) {
                resultStr.append(entry.getKey());
            }
        }

        return resultStr.toString();
    }

    /**
     * Alternate solution...
     *
     * @param S
     * @return
     */
    public static String sortCharacterByFrequencyBucketSort(String S) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            freqMap.put(S.charAt(i), freqMap.getOrDefault(S.charAt(i), 0) + 1);
        }

        List<Character>[] buckets = new List[S.length() + 1];

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            char key = entry.getKey();
            int freq = entry.getValue();

            if(buckets[freq]==null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(key);
        }

        StringBuilder stringBuilder = new StringBuilder(S.length());

        for(int i=buckets.length-1;i>=0;i--) {
            if(buckets[i]!=null) {
                for(char ch:buckets[i]) {
                    for(int j=0;j<i;j++) {
                        stringBuilder.append(ch);
                    }
                }
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);


        result = FrequencySort.sortCharacterByFrequencyBucketSort("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequencyBucketSort("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}