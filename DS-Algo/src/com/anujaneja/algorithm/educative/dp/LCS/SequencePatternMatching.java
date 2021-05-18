package com.anujaneja.algorithm.educative.dp.LCS;

/**
 * Easy - https://www.geeksforgeeks.org/given-two-strings-find-first-string-subsequence-second/
 *
 */
public class SequencePatternMatching {

    public static void main(String[] args) {
        SequencePatternMatching spm = new SequencePatternMatching();
        System.out.println(spm.isSubsequencePatternMatched("baxmx", "ax"));
        System.out.println(spm.isSubsequencePatternMatched("tomorrow", "tor"));
    }

    private boolean isSubsequencePatternMatched(String s1, String s2) {
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

        int LCSLength = dp[m][n];

        return Math.min(s1.length(),s2.length())==LCSLength;
    }
}
