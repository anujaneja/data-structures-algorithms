package com.anujaneja.algorithm.educative.dp;

public class SubsetSumDiffCount {

    public static void main(String[] args) {
        SubsetSumDiffCount ps = new SubsetSumDiffCount();
        int[] num = { 3, 1, 2 ,3 };
        int diff = 3;
        System.out.println(ps.countSubsetSumDiffWays(num,diff));
        num = new int[] { 1, 2, 7, 1, 5 };
        diff = 5;
        System.out.println(ps.countSubsetSumDiffWays(num,diff));
        num = new int[] { 1, 3, 100, 4 };
        diff = 5;
        System.out.println(ps.countSubsetSumDiffWays(num,diff));
    }

    public int countSubsetSumDiffWays(int[] nums,int diff) {

        int sum = 0;
        for(int num:nums) {
            sum+=num;
        }

        if(diff>sum || (diff+sum)%2==1) {
            return 0;
        }
        // s1-s2=diff
        // s1-(sum-s1) = diff;
        // 2s1 = sum+diff
        // s1= (sum+diff)/2;

        int target = (diff+sum)/2;

        //subset count problem...
        int dp[][] = new int[nums.length+1][target+1];

        for (int i=0;i<=nums.length;i++) {
            for (int j=0;j<=target;j++) {
                if(j==0) {
                    dp[i][j] = 1;
                } else if(i==0) {
                    dp[i][j] = 0;
                } else if(nums[i-1]>j) {
                    dp[i][j] = dp[i-1][j];
                } else if(nums[i-1]<=j) {
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[nums.length][target];
    }
}
