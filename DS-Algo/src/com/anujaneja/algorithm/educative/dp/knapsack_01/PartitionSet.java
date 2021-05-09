package com.anujaneja.algorithm.educative.dp.knapsack_01;

/**
 * Medium :  https://leetcode.com/problems/partition-equal-subset-sum/
 * Best Explaination:  https://leetcode.com/problems/partition-equal-subset-sum/discuss/462699/Whiteboard-Editorial.-All-Approaches-explained.
 */
class PartitionSet {

    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = { 1, 2, 3, 9 };
        System.out.println(ps.canPartition(num));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ps.canPartition(num));
        num = new int[] { 1, 3, 100, 4 };
        System.out.println(ps.canPartition(num));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        //Odd sum...
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        Boolean[][] dp = new Boolean[nums.length + 1][target + 1];

        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (i == 0 && j == 0) {
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