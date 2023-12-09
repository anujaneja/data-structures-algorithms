package com.anujaneja.algorithm.takeuforward.recursion;

/*
    1. Time Complexity: O(n) -> Exponential Time complexity
    2. Space Complexity: Stack space for function calls...

    CodingNinja Submission:
    https://www.codingninjas.com/studio/problems/print-1-to-n_628290?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION
 */
public class PrintOne2UsingRecursion {
    public static void printOne2N(int i, int n) {
        if (i > n) {
            return;
        }

        System.out.println(i);
        printOne2N(i + 1, n);
    }

    public static void main(String[] args) {
        printOne2N(1, 10);
    }
}