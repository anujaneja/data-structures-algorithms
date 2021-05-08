package com.anujaneja.algorithm.educative.dp;

public class TargetSum {

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int[] num = { 0, 0, 0, 0, 0, 0, 0, 0, 1 };
        int target = 1;
        System.out.println(ts.findTargetSumWays(num, target));


        num = new int[]{1,1,1,1,1};
        target = 3;
        System.out.println(ts.findTargetSumWays(num, target));


        num = new int[]{1,0};
        target = 1;
        System.out.println(ts.findTargetSumWays(num, target));

    }

    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        int zeroCount = 0;
        for (int num : nums) {
            sum += num;
            if(num==0) {
                zeroCount++;
            }
        }

        if (target > sum || (target + sum) % 2 == 1) {
            return 0;
        }

        int subsetSumTarget = (target + sum) / 2;
        System.out.println("subsetSumTarget: " + subsetSumTarget);

        int dp[][] = new int[nums.length + 1][subsetSumTarget + 1];

        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= subsetSumTarget; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (nums[i - 1] > j || nums[i-1]==0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return (int)Math.pow(2,zeroCount)*dp[nums.length][subsetSumTarget];
    }
}
