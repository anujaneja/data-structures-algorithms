package com.anujaneja.algorithm.educative.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * DP basic...
 * Overlapping Subproblem ->>>
 *      Subproblems are smaller version of original problem.....
 * Optimal Substructure
 *      Fib(n)=Fib(n-1)+Fib(n-2);
 *
 * Solving Approach
 * 1. Top-Down Recursion with Memoization
 * 2. Bottom-up with tabulation
 */
class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacciRec(5));
        System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacciRec(6));
        System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacciRec(7));
        System.out.println("40th Fibonacci is ---> " + fib.CalculateFibonacciRec(40));

        Map<Integer, Integer> memoizedMap = new HashMap<>();
        memoizedMap.put(0, 0);
        memoizedMap.put(1, 1);

        System.out.println("5th Fibonacci is ---> " + fib.calculateFibonacciTopDownWithMemoization(5, memoizedMap));
        System.out.println("6th Fibonacci is ---> " + fib.calculateFibonacciTopDownWithMemoization(6, memoizedMap));
        System.out.println("7th Fibonacci is ---> " + fib.calculateFibonacciTopDownWithMemoization(7, memoizedMap));
        System.out.println("40th Fibonacci is ---> " + fib.calculateFibonacciTopDownWithMemoization(40, memoizedMap));


        System.out.println("5th Fibonacci is ---> " + fib.calculateFibonacciBottomUpWithTabulation(5));
        System.out.println("6th Fibonacci is ---> " + fib.calculateFibonacciBottomUpWithTabulation(6));
        System.out.println("7th Fibonacci is ---> " + fib.calculateFibonacciBottomUpWithTabulation(7));
        System.out.println("40th Fibonacci is ---> " + fib.calculateFibonacciBottomUpWithTabulation(40));

    }

    /**
     * Inefficient one
     * Time complexity is exponential
     * Can be improved using DP - Overlapping subproblem...
     *
     * @param n
     * @return
     */
    public int CalculateFibonacciRec(int n) {
        if (n < 2)
            return n;
        return CalculateFibonacciRec(n - 1) + CalculateFibonacciRec(n - 2);
    }

    /**
     * Top down with Memoization.....
     * Example of Overlapping Subproblem...
     * @param n
     * @param memoizedMap
     * @return
     */
    public int calculateFibonacciTopDownWithMemoization(int n, Map<Integer, Integer> memoizedMap) {
        if (memoizedMap.get(n) != null) {
            return memoizedMap.get(n);
        }

        memoizedMap.put(n, calculateFibonacciTopDownWithMemoization(n - 1, memoizedMap) + calculateFibonacciTopDownWithMemoization(n - 2, memoizedMap));

        return memoizedMap.get(n);

    }

    /**
     * Bottom-up with tabulation
     * Iterative Solution - Real DP...
     */

    public int calculateFibonacciBottomUpWithTabulation(int n) {
        int[] T = new int[n+1];

        T[0]=0;
        T[1]=1;

        for(int i=2;i<=n;i++) {
            T[i] = T[i-1]+T[i-2];
        }

        return T[n];
    }
}