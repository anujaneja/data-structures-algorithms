package com.anujaneja.algorithm.educative.dp.LCS;

import java.util.Arrays;

/**
 *
 * Medium - https://www.geeksforgeeks.org/printing-longest-common-subsequence/
 */
class PrintLCS {

    public static void main(String[] args) {
        PrintLCS lcs = new PrintLCS();

        System.out.println("Print LCS Bottom-up Tabulation -> solution");
        System.out.println(lcs.printLCSBottomUp("abdca", "cbda"));
        System.out.println(lcs.printLCSBottomUp("passport", "ppsspt"));
        System.out.println(lcs.printLCSBottomUp("dynamic", "programming"));

    }

    private String printLCSBottomUp(String s1, String s2) {
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

        StringBuilder builder = new StringBuilder();
        int i=m;
        int j=n;

        while(i>0 && j>0) {
            if(s1.charAt(i-1)==s2.charAt(j-1)) {
                builder.append(s1.charAt(i-1));
                i--;
                j--;
            } else if(s1.charAt(i-1)!=s2.charAt(j-1)) {
                if(dp[i][j-1]>dp[i-1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }

        return builder.reverse().toString();
    }

}
