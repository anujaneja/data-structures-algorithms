package com.anujaneja.algorithm.takeuforward.recursion;

/*
    1. Multiple functions call in recursion
    2. Time Complexity: O(2^n) -> Exponential Time complexity
    3. Space Complexity: Stack space for function calls...
 */
public class Fibonacci {

    public static int fibonacciNumberAt(int n) {
        if (n <= 2) {
            return n - 1;
        }
        return fibonacciNumberAt(n - 1) + fibonacciNumberAt(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci number at: 1 is: " + fibonacciNumberAt(1));
        System.out.println("Fibonacci number at: 2 is: " + fibonacciNumberAt(2));
        System.out.println("Fibonacci number at: 3 is: " + fibonacciNumberAt(3));
        System.out.println("Fibonacci number at: 4 is: " + fibonacciNumberAt(4));
        System.out.println("Fibonacci number at: 5 is: " + fibonacciNumberAt(5));
        System.out.println("Fibonacci number at: 6 is: " + fibonacciNumberAt(6));
        System.out.println("Fibonacci number at: 7 is: " + fibonacciNumberAt(7));
        System.out.println("Fibonacci number at: 8 is: " + fibonacciNumberAt(8));
        System.out.println("Fibonacci number at: 9 is: " + fibonacciNumberAt(9));
        System.out.println("Fibonacci number at: 10 is: " + fibonacciNumberAt(10));
        System.out.println("Fibonacci number at: 20 is: " + fibonacciNumberAt(20));
        System.out.println("Fibonacci number at: 30 is: " + fibonacciNumberAt(30));
    }
}
