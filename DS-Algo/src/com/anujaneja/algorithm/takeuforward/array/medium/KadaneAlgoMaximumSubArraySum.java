package com.anujaneja.algorithm.takeuforward.array.medium;

public class KadaneAlgoMaximumSubArraySum {

    public static long maxSubArraySum(int[] arr) {

        long maxI = Long.MIN_VALUE;
        long sum = 0l;
        int start = -1;
        int aStart = -1;
        int aEnd = -1;
        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) {
                start = i;
            }
            sum = sum + arr[i];
            if (sum > maxI) {
                maxI = sum;
                aStart = start;
                aEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        if (maxI > 0) {
            System.out.print("{");
            for (int i = aStart; i <= aEnd; i++) {
                System.out.print(arr[i] + ",");
            }
            System.out.println("}");
        }
        return maxI > 0 ? maxI : 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -2, 4, -1, -2, 5, 1, -3};
        long maximumSubArrsum = maxSubArraySum(arr);
        System.out.println("maximumSubArrsum is: " + maximumSubArrsum);
    }
}
