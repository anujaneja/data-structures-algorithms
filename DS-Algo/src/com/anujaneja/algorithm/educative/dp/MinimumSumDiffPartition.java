package com.anujaneja.algorithm.educative.dp;

/**
 * Medium - https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
 * VIDEO Explanation: https://www.youtube.com/watch?v=FB0KUhsxXGY&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=11
 */
public class MinimumSumDiffPartition {

    public static void main(String[] args) {
        MinimumSumDiffPartition minimumSumDiffPartition = new MinimumSumDiffPartition();
        int[] nums = new int[] { 1, 6, 11, 5 };
        System.out.println("Minimum sum diff partition array: " + minimumSumDiffPartition.findMinimumSumDiffPartition(nums));
    }

    public int findMinimumSumDiffPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        //target sumset sum...
        boolean dp[][] = new boolean[n+1][sum/2+1];

        for(int i=0;i<=n;++i) {
            for(int j=0;j<=sum/2;++j) {
                if(j==0) {
                    dp[i][j] =true;
                } else if(i==0) {
                    dp[i][j] =false;
                } else if(nums[i-1]>j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }


        int diff = Integer.MAX_VALUE;

        for(int i=0;i<=sum/2;i++) {
            int first = i;
            int second = sum-i;

            if(dp[n][i]==true ) {
                diff = Math.min(diff,Math.abs(second-first));
            }
        }

        return diff;
    }
}
