package com.anujaneja.algorithm.educative;

import java.util.HashMap;

/**
 * Educative - Grokking Coding Interview - Pattens for coding - No. 10
 */
public class LongestSubarrayWithOnesAfterReplacementWithZeros {

    public static int find(int[] arr,int k) {
        int max_length = 0;
        int windowStart=0;
        int maxOnesCount=0;
        HashMap<Integer,Integer> numbersFrequencies = new HashMap<>();

        for(int windowEnd=0;windowEnd<arr.length;windowEnd++) {
            int rightNumber = arr[windowEnd];
            numbersFrequencies.put(rightNumber,numbersFrequencies.getOrDefault(rightNumber,0)+1);

            if(rightNumber==1) {
                maxOnesCount =Math.max(maxOnesCount,numbersFrequencies.get(rightNumber));
            }

            while(windowEnd-windowStart+1-maxOnesCount>k) {
                int leftNumber = arr[windowStart];
                numbersFrequencies.put(leftNumber,numbersFrequencies.get(leftNumber)-1);
                windowStart++;
            }

            max_length = Math.max(max_length,windowEnd-windowStart+1);
        }

        return max_length;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,1,0,0,0,1,1,0,0,1,1};
        int k=2;

        System.out.println("Longest Subarray - length: "+find(arr,k));

        arr = new int[]{0,1,0,0,1,1,0,1,1,0,0,1,1};
        k=3;

        System.out.println("Longest Subarray - length: "+find(arr,k));
    }
}
