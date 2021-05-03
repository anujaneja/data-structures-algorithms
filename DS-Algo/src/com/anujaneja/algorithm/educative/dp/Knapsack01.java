package com.anujaneja.algorithm.educative.dp;

/**
 *
 * https://www.youtube.com/watch?v=kvyShbFVaY8&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=3
 *
 * 01 Knapsack Tabulation Dynamic Programming | How to build DP table
 * https://www.youtube.com/watch?v=WNkqbqyvR_0
 */
public class Knapsack01 {

    public static void main(String[] args) {
        Knapsack01 ks = new Knapsack01();
        int[] profits = { 1, 6, 10, 16 };
        int[] weights = { 1, 2, 3, 5 };
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);

        System.out.println("Top-Down with Memoization...");

        maxProfit = ks.solveKnapsackTopDownWithMemoization(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsackTopDownWithMemoization(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);

        System.out.println("Bottom-Up with Tabulation...");

        maxProfit = ks.solveKnapsackBottomUpWithTabulation(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsackBottomUpWithTabulation(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

    /**
     * Just a recursive appraoch...
     * It has exponential time complexity...
     * To improve this we need to use Top-Down appraoch with Memoization...
     * https://www.youtube.com/watch?v=kvyShbFVaY8&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=3
     *
     * @param profits
     * @param weights
     * @param capacity
     * @return
     */
    private int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int currentIndex = profits.length;
        return solveKnapsackRec(profits, weights, capacity, currentIndex);
    }

    private int solveKnapsackRec(int[] profits, int[] weights, int capacity, int currentIndex) {

        if (capacity == 0 || currentIndex == 0) {
            return 0;
        }

        if (weights[currentIndex-1] <= capacity) {
            return Math.max(profits[currentIndex-1] + solveKnapsackRec(profits, weights, capacity - weights[currentIndex-1], currentIndex - 1),
                    solveKnapsackRec(profits, weights, capacity, currentIndex - 1));
        } else {
            return solveKnapsackRec(profits, weights, capacity, currentIndex - 1);
        }
    }

    /**
     * Top-Down with Memoization
     */
    public int solveKnapsackTopDownWithMemoization(int[] profits, int[] weights, int capacity) {
        int currentIndex = profits.length ;
        int[][] memoized = new int[weights.length + 1][capacity+1];

        for (int i = 0; i <=weights.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    memoized[i][j] = 0;
                } else {
                    memoized[i][j] = -1;
                }
            }
        }

        return solveKnapsackTopDownWithMemoizationRec(profits, weights, capacity, currentIndex, memoized);
    }

    private int solveKnapsackTopDownWithMemoizationRec(int[] profits, int[] weights, int capacity, int currentIndex, int[][] memoized) {
        if (memoized[currentIndex][capacity] != -1) {
            return memoized[capacity][currentIndex];
        }

        if (weights[currentIndex-1] <= capacity) {
            memoized[currentIndex][capacity] = Math.max(profits[currentIndex-1] + solveKnapsackRec(profits, weights, capacity - weights[currentIndex-1], currentIndex - 1),
                    solveKnapsackRec(profits, weights, capacity, currentIndex - 1));

            return memoized[currentIndex][capacity];
        } else {
            memoized[currentIndex][capacity] = solveKnapsackRec(profits, weights, capacity, currentIndex - 1);
            return memoized[currentIndex][capacity];
        }
    }

    public int solveKnapsackBottomUpWithTabulation(int[] profits, int[] weights, int capacity) {
        int[][] T = new int[profits.length + 1][capacity + 1];

        for (int i = 0; i <= profits.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                //base case...
                if (i == 0 || j == 0) {
                    T[i][j] = 0;
                } else if (weights[i - 1] <= j) {
                    T[i][j] = Math.max((profits[i - 1] + T[i - 1][j - weights[i - 1]]), T[i-1][j]);
                } else if (weights[i - 1] > j) {
                    T[i][j] = T[i-1][j];
                }
            }
        }

        return T[profits.length][capacity];
    }

}
