package com.anujaneja.algorithm.educative.dp.LCS;

import java.util.Arrays;

/**
 * Medium - https://www.geeksforgeeks.org/shortest-common-supersequence/
 * https://www.youtube.com/watch?v=823Grn4_dCQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=24
 */
public class SCS {

    public static void main(String[] args) {
        SCS scs = new SCS();
        System.out.println("SCS : Simple recursive");
        System.out.println(scs.findSCSLength("abcf", "bdcf"));
        System.out.println(scs.findSCSLength("dynamic", "programming"));

        System.out.println("SCS : Top-Down Memoization");
        System.out.println(scs.findSCSLengthTopDown("abcf", "bdcf"));
        System.out.println(scs.findSCSLengthTopDown("dynamic", "programming"));

        System.out.println("SCS : Bottom-Up ");
        System.out.println(scs.findSCSLengthBottomUp("abcf", "bdcf"));
        System.out.println(scs.findSCSLengthBottomUp("dynamic", "programming"));
    }

    private int findSCSLengthBottomUp(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                //base Case
                if(i==0 || j==0) {
                    if(i==0) {
                        dp[i][j] = j;
                    }

                    if(j==0) {
                        dp[i][j] = i;
                    }
                    continue;
                }

                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else  {
                    dp[i][j] = 1+ Math.min(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        return dp[m][n];
    }

    private int findSCSLengthTopDown(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return findSCSLengthTopDownRec(s1, s2, m, n, dp);
    }

    private int findSCSLengthTopDownRec(String s1, String s2, int m, int n, int[][] dp) {
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (m == 0) {
            return dp[m][n] = n;
        }

        if (n == 0) {
            return dp[m][n] = m;
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return dp[m][n] = 1 + findSCSLengthRec(s1, s2, m - 1, n - 1);
        } else {
            return dp[m][n] = 1 + Math.min(findSCSLengthRec(s1, s2, m - 1, n), findSCSLengthRec(s1, s2, m, n - 1));
        }
    }

    public int findSCSLength(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        return findSCSLengthRec(s1, s2, m, n);
    }

    private int findSCSLengthRec(String s1, String s2, int m, int n) {
        if (m == 0) {
            return n;
        }

        if (n == 0) {
            return m;
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + findSCSLengthRec(s1, s2, m - 1, n - 1);
        } else {
            return 1 + Math.min(findSCSLengthRec(s1, s2, m - 1, n), findSCSLengthRec(s1, s2, m, n - 1));
        }
    }

}
