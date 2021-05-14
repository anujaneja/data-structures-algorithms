package com.anujaneja.algorithm.educative.dp.unbounded_knapsack;

import java.util.Arrays;

/**
 * Coin Change - I : Max # of ways
 * Medium - https://www.geeksforgeeks.org/coin-change-dp-7/
 * Medium - https://leetcode.com/problems/coin-change-2/
 */
public class CoinChange1 {

    public static void main(String[] args) {
        CoinChange1 coinChange1 = new CoinChange1();
        int[] coins = new int[] { 1, 2, 3 };
        int sum = 5;

        System.out.println("Recursive...No of ways: " + coinChange1.coinChange(coins, sum));

        System.out.println("Top-Down with Memoization...: " + coinChange1.coinChangeWithMemoization(coins, sum));

        System.out.println("Bottom-Up with Tabulation...: " + coinChange1.coinChangeBottomUp(coins, sum));

    }

    public int coinChangeBottomUp(int[] coins, int sum) {
        int[][] dp = new int[coins.length + 1][sum + 1];

        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if(i==0 || j==0) {
                    if(i==0) {
                        dp[i][j] = 0;
                    }

                    if(j==0) {
                        dp[i][j] = 1;
                    }

                    continue;
                }

                if(coins[i-1]>j) {
                    dp[i][j] = dp[i-1][j];
                } else  {
                    dp[i][j] = dp[i][j-coins[i-1]]+dp[i-1][j];
                }
            }


        }

        return dp[coins.length][sum];
    }

    public int coinChangeWithMemoization(int[] coins, int sum) {
        int coins_count = coins.length;

        int[][] dp = new int[coins_count + 1][sum + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return coinChangeWithMemoizationRec(coins, sum, coins_count, dp);
    }

    private int coinChangeWithMemoizationRec(int[] coins, int sum, int coins_count, int[][] dp) {
        if (dp[coins_count][sum] != -1) {
            return dp[coins_count][sum];
        }

        if (coins_count == 0) {
            return dp[coins_count][sum] = 0;
        }

        if (sum == 0) {
            return dp[coins_count][sum] = 1;
        }

        if (coins[coins_count - 1] > sum) {
            return dp[coins_count][sum] = coinChangeRec(coins, sum, coins_count - 1);
        } else {
            return dp[coins_count][sum] = (coinChangeRec(coins, sum - coins[coins_count - 1], coins_count) + coinChangeRec(coins, sum, coins_count - 1));
        }

    }

    public int coinChange(int[] coins, int sum) {
        int coins_count = coins.length;

        return coinChangeRec(coins, sum, coins_count);
    }

    private int coinChangeRec(int[] coins, int sum, int coins_count) {
        if (coins_count == 0) {
            return 0;
        }

        if (sum == 0) {
            return 1;
        }

        if (coins[coins_count - 1] > sum) {
            return coinChangeRec(coins, sum, coins_count - 1);
        } else {
            return coinChangeRec(coins, sum - coins[coins_count - 1], coins_count) + coinChangeRec(coins, sum, coins_count - 1);
        }
    }
}
