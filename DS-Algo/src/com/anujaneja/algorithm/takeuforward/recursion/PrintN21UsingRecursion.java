package com.anujaneja.algorithm.takeuforward.recursion;

/*
    1. Time Complexity: O(n) -> Exponential Time complexity
    2. Space Complexity: Stack space for function calls...
    Coding Ninja Submission:  https://www.codingninjas.com/studio/problems/n-to-1-without-loop_8357243?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION

 */
public class PrintN21UsingRecursion {
    public static void printN2One(int i, int n) {
        if (i > n) {
            return;
        }

        printN2One(i + 1, n);
        System.out.println(i);

    }

    public static void main(String[] args) {
        printN2One(1, 10);
    }
}