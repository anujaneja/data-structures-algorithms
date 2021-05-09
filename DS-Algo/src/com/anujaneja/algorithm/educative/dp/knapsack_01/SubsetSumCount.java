package com.anujaneja.algorithm.educative.dp.knapsack_01;

/**
 * Medium - https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
 * Video explaination:  https://www.youtube.com/watch?v=MqYLmIzl8sQ&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=10
 */
public class SubsetSumCount {
    public static void main(String[] args) {
        SubsetSumCount ss = new SubsetSumCount();
        int[] nums = { 1, 1, 2, 3 };
        System.out.println(ss.countSubsets(nums, 4));
        nums = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.countSubsets(nums, 9));

        System.out.println("Top down with Memoization...");

        nums = new int[]{ 1, 1, 2, 3 };
        System.out.println(ss.countSubsetsTopDownWithM(nums, 4));
        nums = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.countSubsetsTopDownWithM(nums, 9));


        System.out.println("Bottom up with Tabulation...");

        nums = new int[]{ 1, 1, 2, 3 };
        System.out.println(ss.countSubsetsBottomUp(nums, 4));
        nums = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.countSubsetsBottomUp(nums, 9));
    }

    private int countSubsets(int[] nums, int sum) {
        int n = nums.length;
        return countSubsetsRec(nums, sum, n);
    }


    private int countSubsetsRec(int[] nums, int sum, int n) {

        if (sum == 0) {
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        if (nums[n - 1] > sum) {
            return countSubsetsRec(nums, sum, n - 1);
        } else  {
            return countSubsetsRec(nums, sum, n - 1) + countSubsetsRec(nums, sum - nums[n - 1], n - 1);
        }

    }

    private int countSubsetsTopDownWithM(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[nums.length+1][sum+1];
        for(int i=0;i<=nums.length;i++) {
            for(int j=0;j<=sum;j++){


                if(i==0 || j==0) {

                    if(i==0) {
                        dp[i][j]=0;
                    }

                    if(j==0) {
                        dp[i][j]=1;
                    }

                } else {
                    dp[i][j]=-1;
                }



            }
        }
        return countSubsetsTopDownWithMRec(nums, sum, n,dp);
    }


    private int countSubsetsTopDownWithMRec(int[] nums, int sum, int n,int[][] dp) {

        if(dp[n][sum]!=-1) {
            return dp[n][sum];
        }


        if (sum == 0) {
            dp[n][sum]=1;
            return dp[n][sum];
        }

        if (n == 0) {
            dp[n][sum]=0;
            return dp[n][sum];
        }



        if (nums[n - 1] > sum) {
            dp[n][sum] = countSubsetsRec(nums, sum, n - 1);
            return dp[n][sum];
        } else  {
            return dp[n][sum] = countSubsetsRec(nums, sum, n - 1) + countSubsetsRec(nums, sum - nums[n - 1], n - 1);
        }

    }



    public int countSubsetsBottomUp(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[nums.length+1][sum+1];
        for(int i=0;i<=nums.length;i++) {
            for(int j=0;j<=sum;j++){


                if(i==0 || j==0) {

                    if(i==0) {
                        dp[i][j]=0;
                    }

                    if(j==0) {
                        dp[i][j]=1;
                    }
                } else if(nums[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                } else if(nums[i-1]<=j) {
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-nums[i-1]];
                }

            }
        }

        return dp[nums.length][sum];
    }

}

