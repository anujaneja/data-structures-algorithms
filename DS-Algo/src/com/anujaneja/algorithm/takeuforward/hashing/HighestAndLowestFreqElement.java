package com.anujaneja.algorithm.takeuforward.hashing;

import java.util.HashMap;
import java.util.Map;

/*
    Link: https://www.codingninjas.com/studio/problems/k-most-occurrent-numbers_625382?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

 */
public class HighestAndLowestFreqElement {
    public static int[] getFrequencies(int[] v) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : v) {
            if (freqMap.containsKey(num)) {
                freqMap.put(num, freqMap.get(num) + 1);
            } else {
                freqMap.put(num, 1);
            }
        }

        int maxFreq = 0;
        int minFreq = Integer.MAX_VALUE;
        int maxFreqE = Integer.MAX_VALUE;
        int minFreqE = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            Integer number = entry.getKey();
            Integer freq = entry.getValue();

            if (freq > maxFreq) {
                maxFreq = freq;
                maxFreqE = number;
            } else if (freq == maxFreq) {
                maxFreqE = Math.min(maxFreqE, number);
                ;
            }

            if (freq < minFreq) {
                minFreq = freq;
                minFreqE = number;
            } else if (freq == minFreq) {
                minFreqE = Math.min(minFreqE, number);
            }
        }
        return new int[]{maxFreqE, minFreqE};

    }

    public static void main(String[] args) {

    }
}
