package com.anujaneja.algorithm.educative.dp.LCS;

/**
 * Medium  - https://www.geeksforgeeks.org/longest-repeated-subsequence/
 *
 */
class LRS {

    public static void main(String[] args) {
        LRS lrs = new LRS();
        System.out.println(lrs.findLRSLength("tomorrow"));
        System.out.println(lrs.findLRSLength("aabdbcec"));
        System.out.println(lrs.findLRSLength("fmff"));
    }

    public int findLRSLength(String str) {
        int n = str.length();
        return findLRSLengthRecursive(str, n, n);
    }

    private int findLRSLengthRecursive(String str, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (str.charAt(m - 1) == str.charAt(n - 1) && m!=n) {
            return 1 + findLRSLengthRecursive(str, m - 1, n - 1);
        } else {
            return Math.max(findLRSLengthRecursive(str, m, n - 1), findLRSLengthRecursive(str, m - 1, n));
        }
    }
}
