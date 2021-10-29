package com.anujaneja.algorithm.array.matrix;

public class MinSumPathMatrix {
    public int minPathSum(int[][] grid) {
        int m=grid.length-1;
        int n=grid[0].length-1;
        int[][] dp = new int[m+1][n+1];
        return minPathSumRec(grid,m,n,dp);
    }


    public int minPathSumRec(int[][] grid,int m,int n,int[][] dp) {
        //Base Case 1
        if(m<0 || n<0) {
            return Integer.MAX_VALUE;
        }

        //Base: Terminating condition (0,0)
        if(m==0 && n==0) {
            return grid[m][n];
        }

        if(dp[m][n]==0) {
            dp[m][n] = grid[m][n]+Math.min(minPathSumRec(grid,m-1,n,dp),minPathSumRec(grid,m,n-1,dp));
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
//        "[[1,3,1],[1,5,1],[4,2,1]]"
        int[][] grid = new int[][]{
                {1,3,1},{1,5,1},{4,2,1}
        };
        MinSumPathMatrix minSumPathMatrix = new MinSumPathMatrix();
        System.out.println(">> MinSumPathMatrix: "+minSumPathMatrix.minPathSum(grid));

    }
}
