package com.anujaneja.algorithm.educative.dp.knapsack_01;

/**
 * Medium - https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 * VIDEO EXPLANATION - https://www.youtube.com/watch?v=34l1kTIQCIA&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=8
 */
public class SubsetSumDP {
    public static boolean subsetSumFound(int[] nums, int target) {
        int currentIndex = nums.length;
        return subsetSumFoundRec(nums, target, currentIndex);

    }

    private static boolean subsetSumFoundRec(int[] nums, int target, int currentIndex) {
        //base cases...
        if (target == 0) {
            return true;
        }

        if (currentIndex == 0 && target != 0) {
            return false;
        }

        //last element is greater than target sum
        //we need to skip it...
        if (nums[currentIndex - 1] > target) {
            return subsetSumFoundRec(nums, target, currentIndex - 1);
        }

        return subsetSumFoundRec(nums, target - nums[currentIndex - 1], currentIndex - 1) ||
                subsetSumFoundRec(nums, target, currentIndex - 1);
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1 };
        System.out.println(SubsetSumDP.subsetSumFound(nums, 10));
        nums = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(SubsetSumDP.subsetSumFound(nums, 9));

        nums = new int[] { 2, 3, 1 };
        System.out.println(SubsetSumDP.subsetSumFoundDP(nums, 0));
        nums = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(SubsetSumDP.subsetSumFoundDP(nums, 9));


        nums = new int[] { 2, 3, 1 };
        System.out.println(SubsetSumDP.subsetSumFoundBottomUpTabulation(nums, 10));
        nums = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(SubsetSumDP.subsetSumFoundBottomUpTabulation(nums, 9));


    }

    public static boolean subsetSumFoundDP(int[] nums, int target) {
        int currentIndex = nums.length;
        Boolean[][] dp = new Boolean[nums.length + 1][target + 1];
        return subsetSumFoundRecDP(nums, target, currentIndex, dp);

    }

    private static boolean subsetSumFoundRecDP(int[] nums, int target, int currentIndex, Boolean[][] dp) {

        if (dp[currentIndex][target] != null) {
            return dp[currentIndex][target];
        }

        //base cases...
        if (target == 0) {
            dp[currentIndex][target] = true;
            return dp[currentIndex][target];
        }

        if (currentIndex == 0 && target != 0) {
            dp[currentIndex][target] = false;
            return dp[currentIndex][target];
        }

        if (nums[currentIndex - 1] > target) {
            dp[currentIndex][target] = subsetSumFoundRec(nums, target, currentIndex - 1);
        } else {
            dp[currentIndex][target] = subsetSumFoundRec(nums, target - nums[currentIndex - 1], currentIndex - 1) ||
                    subsetSumFoundRec(nums, target, currentIndex - 1);
        }

        return dp[currentIndex][target];
    }

    public static boolean subsetSumFoundBottomUpTabulation(int[] nums, int target) {
        Boolean[][] dp = new Boolean[nums.length + 1][target + 1];

        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if(i==0 && j==0) {
                    dp[i][j] = true;
                    continue;
                }
                //base cases...
                if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }

                if (i == 0) {
                    dp[i][j] = false;
                    continue;
                }

                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }
            }
        }

        return dp[nums.length][target];
    }

}
