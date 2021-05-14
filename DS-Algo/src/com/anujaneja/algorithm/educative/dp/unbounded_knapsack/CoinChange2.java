package com.anujaneja.algorithm.educative.dp.unbounded_knapsack;

import java.util.Arrays;

/**
 * Medium - https://leetcode.com/problems/coin-change/
 * https://www.youtube.com/watch?v=ZI17bgz07EE&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=14
 * https://www.youtube.com/watch?v=I-l6PBeERuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=17&t=542s
 */
public class CoinChange2 {

    public static void main(String[] args) {
        CoinChange2 coinChange2 = new CoinChange2();
        int[] coins = new int[] { 7, 4, 5 };
        int amount = 6;

        System.out.println("Recursive...No of ways: " + coinChange2.coinChange(coins, amount));

        System.out.println("Top-Down with Memoization...: " + coinChange2.coinChangeWithMemoization(coins, amount));

        System.out.println("Bottom-Up with Tabulation...: " + coinChange2.coinChangeBottomUp(coins, amount));

    }

    private int coinChangeBottomUp(int[] coins, int amount) {
        int coins_count = coins.length;
        int[][] dp = new int[coins_count + 1][amount + 1];

        for (int i = 0; i <= coins_count; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j > 0 && i == 0) {
                    dp[i][j] = Integer.MAX_VALUE - 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min((1 + dp[i][j - coins[i - 1]]), dp[i - 1][j]);
                }
            }
        }

        return dp[coins_count][amount]>=Integer.MAX_VALUE-1?-1:dp[coins_count][amount];
    }

    private int coinChangeWithMemoization(int[] coins, int amount) {
        int coins_count = coins.length;
        int[][] dp = new int[coins_count + 1][amount + 1];
        for (int i = 0; i <= coins_count; i++) {
            Arrays.fill(dp[i], -1);
        }
        int result = coinChangeWithMemoizationRec(coins, amount, coins_count, dp);
        return result >= Integer.MAX_VALUE - 1 ? -1 : result;

    }

    private int coinChangeWithMemoizationRec(int[] coins, int amount, int coins_count, int[][] dp) {
        if (dp[coins_count][amount] != -1) {
            return dp[coins_count][amount];
        }

        if (amount > 0 && coins_count == 0) {
            return dp[coins_count][amount] = Integer.MAX_VALUE - 1;
        }

        if (coins_count == 0) {
            return dp[coins_count][amount] = 0;
        }

        if (coins[coins_count - 1] > amount) {
            dp[coins_count][amount] = coinChangeRec(coins, amount, coins_count - 1);
        } else {
            dp[coins_count][amount] = Math.min((1 + coinChangeRec(coins, amount - coins[coins_count - 1], coins_count)), coinChangeRec(coins, amount, coins_count - 1));
        }

        return dp[coins_count][amount];
    }

    private int coinChange(int[] coins, int amount) {
        int coins_count = coins.length;
        int result = coinChangeRec(coins, amount, coins_count);
        return result >= Integer.MAX_VALUE - 1 ? -1 : result;
    }

    private int coinChangeRec(int[] coins, int amount, int coins_count) {
        if (amount > 0 && coins_count == 0) {
            return Integer.MAX_VALUE - 1;
        }

        if (coins_count == 0) {
            return 0;
        }

        if (coins[coins_count - 1] > amount) {
            return coinChangeRec(coins, amount, coins_count - 1);
        } else {
            return Math.min((1 + coinChangeRec(coins, amount - coins[coins_count - 1], coins_count)), coinChangeRec(coins, amount, coins_count - 1));
        }
    }
}
