package com.anujaneja.algorithm.takeuforward.recursion;

/*
    1. Time Complexity: O(n) -> Exponential Time complexity
    2. Space Complexity: Stack space for function calls...

    Coding Ninja: Submission https://www.codingninjas.com/studio/problems/sum-of-first-n-numbers_8876068?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
 */
public class SumOfFirstNNumbersUsingRecursion {
    public static int sumOfN(int i, int n, int sum) {
        if (i > n) {
            return sum;
        }

        return i + sumOfN(i + 1, n, sum);
    }

    public static void main(String[] args) {
        int sum = 0;
        sum = sumOfN(1, 10, sum);
        System.out.println("sum=" + sum);
    }
}