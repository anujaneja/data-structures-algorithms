package com.anujaneja.algorithm.array.matrix;

// Easy- https://leetcode.com/problems/unique-paths/
public class UniquePaths1 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return uniquePathsRec(m-1,n-1,dp);
    }

    public int uniquePathsRec(int m, int n,int[][] dp) {
        if(dp[m][n]!=0) {
            return dp[m][n];
        }

        if(m==0 || n==0) {
            return 1;
        }

        if(m==0 && n==0) {
            return 0;
        }

        return dp[m][n]=(uniquePathsRec(m-1,n,dp)+uniquePathsRec(m,n-1,dp));
    }

    public static void main(String[] args) {
        int count = new UniquePaths1().uniquePaths(3,4);
        System.out.println("Total No of paths: "+count);
    }
}
