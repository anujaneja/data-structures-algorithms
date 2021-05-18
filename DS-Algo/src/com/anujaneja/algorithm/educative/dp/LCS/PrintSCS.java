package com.anujaneja.algorithm.educative.dp.LCS;

import java.util.Arrays;

/**
 * Hard - https://www.geeksforgeeks.org/print-shortest-common-supersequence/
 * Hard - https://leetcode.com/problems/shortest-common-supersequence/
 * https://www.youtube.com/watch?v=VDhRg-ZJTuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=29
 * NOTE: Also, SCS Length = s1.length()+s2.length()-LCS.length()
 * Approach - 1: Find LCS and fill dp 2-d matrix and use it
 * backtrack the string based on the conditions as per SCS.
 */
public class PrintSCS {

    public static void main(String[] args) {
        PrintSCS scs = new PrintSCS();


        System.out.println("Print SCS : Bottom-Up ");
        System.out.println(scs.printSCS("abcf", "bdcf"));
        System.out.println(scs.printSCS("dynamic", "programming"));

        System.out.println("Print SCS : Bottom-Up - printSCSUsingSCSLength");
        System.out.println(scs.printSCSUsingSCSLength("abcf", "bdcf"));
        System.out.println(scs.printSCSUsingSCSLength("dynamic", "programming"));
    }

    public String printSCS(String s1, String s2) {
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

        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if(s1.charAt(i-1)==s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else {
                if(dp[i][j-1]>dp[i-1][j]) {
                    sb.append(s2.charAt(j-1));
                    j--;
                } else {
                    sb.append(s1.charAt(i-1));
                    i--;
                }
            }
        }

        while(i>0) {
            sb.append(s1.charAt(i-1));
            i--;
        }

        while(j>0) {
            sb.append(s2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }

    public String printSCSUsingSCSLength(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                //base Case
                if (i == 0 || j == 0) {
                    if (i == 0) {
                        dp[i][j] = j;
                    }

                    if (j == 0) {
                        dp[i][j] = i;
                    }
                    continue;
                }

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }



        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if(s1.charAt(i-1)==s2.charAt(j-1)) {
                sb.insert(0,s1.charAt(i-1));
                i--;
                j--;
            } else {
                if(dp[i][j-1]>dp[i-1][j]) {
                    sb.insert(0,s1.charAt(i-1));
                    i--;
                } else {
                    sb.insert(0,s2.charAt(j-1));
                    j--;
                }
            }
        }

        while(i>0) {
            sb.insert(0,s1.charAt(i-1));
            i--;
        }

        while(j>0) {
            sb.insert(0,s2.charAt(j-1));
            j--;
        }
        return sb.toString();
    }
}
