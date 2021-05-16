package com.anujaneja.algorithm.educative.dp.LCS;

/**
 * Medium - https://leetcode.com/problems/longest-palindromic-subsequence/
 */
class LPS {

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

  public static void main(String[] args) {
    LPS lps = new LPS();
    System.out.println(lps.findLPSLength("abdbca"));
    System.out.println(lps.findLPSLength("cddpd"));
    System.out.println(lps.findLPSLength("pqr"));
  }
}
