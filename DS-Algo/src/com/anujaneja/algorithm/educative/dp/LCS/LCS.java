package com.anujaneja.algorithm.educative.dp.LCS;

import java.util.Arrays;

class LCS {

    public static void main(String[] args) {
        LCS lcs = new LCS();
        System.out.println("LCS Simple Recursive solution");
        System.out.println(lcs.findLCSLength("abdca", "cbda"));
        System.out.println(lcs.findLCSLength("passport", "ppsspt"));

        System.out.println("LCS Recursive + Memoization -> Top-Down solution");
        System.out.println(lcs.findLCSLengthTopDown("abdca", "cbda"));
        System.out.println(lcs.findLCSLengthTopDown("passport", "ppsspt"));

        System.out.println("LCS Bottom-up Tabulation -> solution");
        System.out.println(lcs.findLCSLengthBottomUp("abdca", "cbda"));
        System.out.println(lcs.findLCSLengthBottomUp("passport", "ppsspt"));

    }

    private int findLCSLengthBottomUp(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }

    /**
     * Simple recursive solution...
     *
     * @param s1
     * @param s2
     * @return
     */
    public int findLCSLength(String s1, String s2) {
        return findLCSLengthRecursive(s1, s2, s1.length(), s2.length());
    }

    private int findLCSLengthRecursive(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return (1 + findLCSLengthRecursive(s1, s2, m - 1, n - 1));
        } else {
            return Math.max(findLCSLengthRecursive(s1, s2, m, n - 1), findLCSLengthRecursive(s1, s2, m - 1, n));
        }
    }

    private int findLCSLengthTopDown(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return findLCSLengthTopDownRecursive(s1, s2, s1.length(), s2.length(), dp);
    }

    private int findLCSLengthTopDownRecursive(String s1, String s2, int m, int n, int[][] dp) {
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (m == 0 || n == 0) {
            return dp[m][n] = 0;
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return dp[m][n] = (1 + findLCSLengthTopDownRecursive(s1, s2, m - 1, n - 1, dp));
        } else {
            return dp[m][n] = Math.max(findLCSLengthTopDownRecursive(s1, s2, m, n - 1, dp), findLCSLengthTopDownRecursive(s1, s2, m - 1, n, dp));
        }

    }
}
