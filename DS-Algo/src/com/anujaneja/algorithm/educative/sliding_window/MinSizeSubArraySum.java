package com.anujaneja.algorithm.educative.sliding_window;

/**
 * Problem statement:
 * https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
 */
public class MinSizeSubArraySum {

    public static int findMinSubArray(int[] arr,int S) {
        int minSubArrayLength = Integer.MAX_VALUE;
        int windowStart =0,windowEnd=0;
        int windowSum = 0;


        while(windowEnd<arr.length){

            windowSum+=arr[windowEnd];

            while(windowSum>=S) {
                minSubArrayLength=Math.min(windowEnd-windowStart+1,minSubArrayLength);
                windowSum-=arr[windowStart];
                windowStart++;
            }
                windowEnd++;


        }

        return minSubArrayLength==Integer.MAX_VALUE?0:minSubArrayLength;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,1,5,2,3,2};

        int S = 5;

        int minLength = findMinSubArray(arr,S);

        System.out.println("minLength: "+minLength);
    }
}
