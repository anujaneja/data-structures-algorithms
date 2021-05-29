package com.anujaneja.algorithm.educative.dp.LCS;

/**
 * Medium - https://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome/
 */
class MISP {

    public static void main(String[] args) {
        MISP mdsp = new MISP();
        System.out.println(mdsp.findMinimumInsertion("abdbca"));
        System.out.println(mdsp.findMinimumInsertion("cddpd"));
        System.out.println(mdsp.findMinimumInsertion("pqr"));
    }

    public int findMinimumInsertion(String st) {
        //LCS length of str and its reverse will give largest Palindrom.
        // minDeletionCount = st.length() - LPS Length = MinInsertionCount
        int lpsLength = findLPSLength(st);

        return st.length() - lpsLength;
    }

    public int findLPSLength(String st) {
        String reverseString = new StringBuilder(st).reverse().toString();
        int lpsLength = findLCSLength(st,reverseString);

        return lpsLength;
    }

    private int findLCSLength(String s1, String s2) {
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
}