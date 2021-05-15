package com.anujaneja.algorithm.educative.dp.LCS;

import java.util.Arrays;

/**
 * Similar Question
 * Medium - https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 */
public class LongestCommonSubstring {

    public static void main(String[] args) {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        System.out.println("Longest common substring Length - Recursive");

        System.out.println(lcs.findLCSLength("abdca", "cbda"));
        System.out.println(lcs.findLCSLength("passport", "ppsspt"));

        System.out.println("Longest common substring Length - Top-Down with Memoization");

        System.out.println(lcs.findLCSLengthTopDown("abdca", "cbda"));
        System.out.println(lcs.findLCSLengthTopDown("passport", "ppsspt"));

        System.out.println("Longest common substring Length - Bottom-up with Tabulation");

        System.out.println(lcs.findLCSLengthBottomUp("abdca", "cbda"));
        System.out.println(lcs.findLCSLengthBottomUp("passport", "ppsspt"));

    }

    private int findLCSLengthBottomUp(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m + 1][n + 1];

        int max_result = 0;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                //base case
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                    max_result = Math.max(max_result,dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max_result;
    }

    private int findLCSLengthTopDown(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return findLCSLengthTopDownRecursive(s1, s2, m, n, 0, dp);
    }

    private int findLCSLengthTopDownRecursive(String s1, String s2, int m, int n, int count, int[][] dp) {
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (m == 0 || n == 0) {
            return dp[m][n] = 0;
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return dp[m][n] = findLCSLengthRecursive(s1, s2, m - 1, n - 1, count + 1);
        } else {
            return dp[m][n] = Math.max(count, Math.max(findLCSLengthRecursive(s1, s2, m, n - 1, 0), findLCSLengthRecursive(s1, s2, m - 1, n, 0)));
        }
    }

    /**
     * Simple Recursive
     *
     * @param s1
     * @param s2
     * @return
     */
    public int findLCSLength(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        return findLCSLengthRecursive(s1, s2, m, n, 0);
    }

    private int findLCSLengthRecursive(String s1, String s2, int m, int n, int count) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return findLCSLengthRecursive(s1, s2, m - 1, n - 1, count + 1);
        } else {
            return Math.max(count, Math.max(findLCSLengthRecursive(s1, s2, m, n - 1, 0), findLCSLengthRecursive(s1, s2, m - 1, n, 0)));
        }
    }

}
