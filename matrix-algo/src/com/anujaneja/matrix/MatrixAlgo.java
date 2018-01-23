package com.anujaneja.matrix;

/**
 * I have implemented a Greedy Solution which will not work here.
 */
public class MatrixAlgo {

    public static int computeRocks(int[][] grid) {

        int noOfRocks = 0;
        int i=grid.length-1;
        int j= 0;

        while(i>=0 && j<=grid[i].length-1) {

            System.out.print(grid[i][j]+"->");

            noOfRocks+=grid[i][j];

            int eastElement = j<grid[i].length-1? grid[i][j+1]: Integer.MIN_VALUE;
                    //grid[i][Math.min(j+1,grid[i].length-1)];
            int northElement = i-1>=0 ? grid[i-1][j]: Integer.MIN_VALUE;
                    //grid[Math.max(i-1,0)][j];

            if(eastElement<=northElement) {
                //there is north option.
                i--;


            } else {
                j++;
            }

        }


        return noOfRocks;
    }

    public static void main(String[] args) {

        int result = computeRocks(new int[][]{
                {0,0,0,0,5},
                {0,1,1,1,0},
                {2,0,0,0,0},
                {4,0,0,0,0},
                {4,0,0,0,0},
                {4,0,0,0,0},
                {4,0,0,0,5},
                {4,0,0,0,4},
                {4,0,0,0,0},
                {4,0,0,0,4},
                {4,0,0,0,4},
                {4,0,0,0,0},
                {4,0,0,0,0},
                {4,0,0,0,0},
                {4,0,0,0,0}
        });

        System.out.println("\nResult is:="+result);

        if(result==25) {
            System.out.print("Test Passed");
        } else {
            System.out.print("Test Fail");
        }
    }
}
