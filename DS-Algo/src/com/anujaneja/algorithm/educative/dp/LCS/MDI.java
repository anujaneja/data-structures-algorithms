package com.anujaneja.algorithm.educative.dp.LCS;

/**
 * Medium - https://www.geeksforgeeks.org/minimum-number-deletions-insertions-transform-one-string-another/
 */
class MDI {

  public void findMDI(String s1, String s2) {
    int c1 = findLCSLength(s1, s2);
    System.out.println("Minimum deletions needed: " + (s1.length() - c1));
    System.out.println("Minimum insertions needed: " + (s2.length() - c1));
  }
  
  private int findLCSLength(String s1, String s2) {
    int m = s1.length();
    int n=s2.length();
    int[][] dp = new int[m+1][n+1];

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
    MDI mdi = new MDI();
    mdi.findMDI("abc", "fbc");
    mdi.findMDI("abdca", "cbda");
    mdi.findMDI("passport", "ppsspt");
    mdi.findMDI("heap","pea");
  }
}