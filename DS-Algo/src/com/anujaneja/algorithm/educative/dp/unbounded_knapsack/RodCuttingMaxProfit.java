package com.anujaneja.algorithm.educative.dp.unbounded_knapsack;

import java.util.Arrays;

/**
 * Medium : https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
 * https://www.youtube.com/watch?v=SZqAQLjDsag&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=14
 */
public class RodCuttingMaxProfit {

    public static void main(String args[]) {
        RodCuttingMaxProfit rodCuttingMaxProfit = new RodCuttingMaxProfit();
        int profits[] = new int[] { 1, 5, 4, 1 };
        int lengths[] = new int[profits.length];

        for (int i = 0; i < profits.length; i++) {
            lengths[i] = i + 1;
        }
        int max_rod_length = profits.length;

        System.out.println("Maximum Obtainable Value is " +
                rodCuttingMaxProfit.cutRod(profits, lengths, max_rod_length));

        System.out.println("Top-Down with Memozation: Maximum Obtainable Value is " +
                rodCuttingMaxProfit.cutRodMemoization(profits, lengths, max_rod_length));

        System.out.println("Bottom-up with Tabulation: Maximum Obtainable Value is " +
                rodCuttingMaxProfit.cutRodBottomUpTabulation(profits, lengths, max_rod_length));

    }

    /**
     * Top down recursive solution...
     *
     * @param profits
     * @param lengths
     * @param max_rod_length
     * @return
     */

    public int cutRod(int[] profits, int[] lengths, int max_rod_length) {
        int current_length = max_rod_length;
        return cutRodRec(profits, lengths, max_rod_length, current_length);
    }

    private int cutRodRec(int[] profits, int[] lengths, int max_rod_length, int current_length) {

        /**
         * Base case...
         */
        if (max_rod_length == 0 || current_length == 0) {
            return 0;
        }

        //Exclude if current length is greater than the max length...
        if (lengths[current_length - 1] > max_rod_length) {
            return cutRodRec(profits, lengths, max_rod_length, current_length - 1);
        } else {
            /**
             * 1. Include multiple occurennce (NOTE: current_length is not changed...) or
             * 2. Exclude then current_length is decremented.
             * 3. Very similiar to 0/1 Knapsack just one difference pointed out in 1st point.
             */
            return Math.max((profits[current_length - 1] + cutRodRec(profits, lengths, max_rod_length - lengths[current_length - 1], current_length)),
                    cutRodRec(profits, lengths, max_rod_length, current_length - 1));
        }
    }

    public int cutRodMemoization(int[] profits, int[] lengths, int max_rod_length) {
        int current_length = max_rod_length;
        int[][] dp = new int[lengths.length + 1][max_rod_length + 1];
        //Fill all with -1 as value...
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return cutRodMemoizationRec(profits, lengths, max_rod_length, current_length, dp);
    }

    private int cutRodMemoizationRec(int[] profits, int[] lengths, int max_rod_length, int current_length, int[][] dp) {
        if (dp[current_length][max_rod_length] != -1) {
            return dp[current_length][max_rod_length];
        }

        /**
         * Base case...
         */
        if (max_rod_length == 0 || current_length == 0) {
            return dp[current_length][max_rod_length] = 0;
        }

        //Exclude if current length is greater than the max length...
        if (lengths[current_length - 1] > max_rod_length) {
            dp[current_length][max_rod_length] = cutRodRec(profits, lengths, max_rod_length, current_length - 1);
        } else {
            /**
             * 1. Include multiple occurennce (NOTE: current_length is not changed...) or
             * 2. Exclude then current_length is decremented.
             * 3. Very similiar to 0/1 Knapsack just one difference pointed out in 1st point.
             */
            dp[current_length][max_rod_length] = Math.max((profits[current_length - 1] + cutRodRec(profits, lengths, max_rod_length - lengths[current_length - 1], current_length)),
                    cutRodRec(profits, lengths, max_rod_length, current_length - 1));
        }

        return dp[current_length][max_rod_length];
    }

    public int cutRodBottomUpTabulation(int[] profits, int[] lengths, int max_rod_length) {
        int[][] dp = new int[lengths.length + 1][max_rod_length + 1];
        //Fill all with -1 as value...
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i <= lengths.length; i++) {
            for (int j = 0; j <= max_rod_length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if(lengths[i-1]>j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max((profits[i-1]+dp[i][j-lengths[i-1]]),dp[i-1][j]);
                }
            }
        }

        return dp[lengths.length][max_rod_length];
    }
}
