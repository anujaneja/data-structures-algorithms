package com.anujaneja.algorithm.array.matrix;

import java.util.Arrays;

public class UniquePathsCountWithObstracles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length-1;
        int n=obstacleGrid[0].length-1;
        int[][] dp = new int[m+1][n+1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return uniquePathsWithObstaclesRec(obstacleGrid,m,n,dp);
    }

    public int uniquePathsWithObstaclesRec(int[][] obstacleGrid,int m,int n,int[][] dp) {
        //Already computed return as it as...
        if(dp[m][n]!=-1) {
            return dp[m][n];
        }

        if(obstacleGrid[m][n]==1) {
            return 0;
        }

        //Base Terminating Condition
        if(m==0 && n==0) {
            return 1;
        }

        //Obstracle handling...
        if(m==0) {
            return dp[m][n] = uniquePathsWithObstaclesRec(obstacleGrid,m,n-1,dp);
        } else if(n==0) {
            return dp[m][n] = uniquePathsWithObstaclesRec(obstacleGrid,m-1,n,dp);
        }

        return dp[m][n] = uniquePathsWithObstaclesRec(obstacleGrid,m-1,n,dp)+uniquePathsWithObstaclesRec(obstacleGrid,m,n-1,dp);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,0},{0,1,0},{0,0,0}
        };
        UniquePathsCountWithObstracles uniquePathsCountWithObstracles =  new UniquePathsCountWithObstracles();
        System.out.println(">> uniquePathsCountWithObstracles count: "+uniquePathsCountWithObstracles.uniquePathsWithObstacles(grid));
    }
}
