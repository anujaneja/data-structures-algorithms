package com.anujaneja.algorithm.array;

import java.util.Arrays;
import java.util.List;

public class MaxSubArraySumKadaneAlgo {

    public static int maxSubArraySum(final List<Integer> A) {
        int maxSubArraySum = 0;
        int currentSubArrSum = 0;
        int maxElement = Integer.MIN_VALUE;

        for (int i = 0; i < A.size(); i++) {
            Integer a = A.get(i);

            if (maxElement < a) {
                maxElement = a;
            }

            currentSubArrSum += a;
            if (currentSubArrSum < 0) {
                currentSubArrSum = 0;
            } else if (currentSubArrSum > maxSubArraySum) {
                maxSubArraySum = currentSubArrSum;
            }
        }

        if (maxElement < 0) {
            maxSubArraySum = maxElement;
        }

        return maxSubArraySum;
    }

    public static void main(String[] args) {
        List<Integer> al1 = Arrays.asList(1,2,3,4,-10);
        int maxSum1 = maxSubArraySum(al1);

        System.out.println(maxSum1);

        if(maxSum1!=10) {
            System.out.println("Test case fail!");
        }


        List<Integer> al2 = Arrays.asList(-2, -3, 4, -1, -2, 1, 5, -3);
        int maxSum2 = maxSubArraySum(al2);

        System.out.println(maxSum2);

        if(maxSum2!=7) {
            System.out.println("Test case fail!");
        }


        List<Integer> al3 = Arrays.asList(0,-1,-2,-100);
        int maxSum3 = maxSubArraySum(al3);

        System.out.println(maxSum3);

        if(maxSum3!=0) {
            System.out.println("Test case fail!");
        }


        List<Integer> al4 = Arrays.asList(-10,-100);
        int maxSum4 = maxSubArraySum(al4);

        System.out.println(maxSum4);

        if(maxSum4!=-10) {
            System.out.println("Test case fail!");
        }
    }
}
