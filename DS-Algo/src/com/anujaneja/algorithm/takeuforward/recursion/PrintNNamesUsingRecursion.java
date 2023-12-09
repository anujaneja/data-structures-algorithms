package com.anujaneja.algorithm.takeuforward.recursion;

/*
    1. Time Complexity: O(n) -> Exponential Time complexity
    2. Space Complexity: Stack space for function calls...
 */
public class PrintNNamesUsingRecursion {
    private static String NAME = "Anuj Aneja";

    public static void printNNames(int i, int n) {
        if (i > n) {
            return;
        }

        System.out.println(NAME);
        printNNames(i + 1, n);
    }

    public static void main(String[] args) {
        printNNames(1, 10);
    }
}