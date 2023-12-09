package com.anujaneja.algorithm.takeuforward.recursion;

/*
    1. Time Complexity: O(n) -> Exponential Time complexity
    2. Space Complexity: Stack space for function calls...
 */
public class Factorial {
    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static void main(String[] args) {
        int fact = fact(5);

        System.out.println(fact);

        fact = fact(0);

        System.out.println(fact);

        fact = fact(6);

        System.out.println(fact);


    }
}
