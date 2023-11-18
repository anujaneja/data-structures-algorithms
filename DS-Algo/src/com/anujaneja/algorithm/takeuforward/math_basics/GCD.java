package com.anujaneja.algorithm.takeuforward.math_basics;

/*
https://www.codingninjas.com/studio/problems/hcf-and-lcm_840448?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION
Time Complexity: O(log(n))
Algorithm Used: Euclidean Theorem -> GCD(a,b) -> GCD(a-b,b) Given a>b
 */
public class GCD {
    public static int calcGCD(int n, int m) {
        // Write your code here.
        if (n == 0 && m != 0) {
            return m;
        }

        return calcGCD(Math.max(n, m) % Math.min(n, m), Math.min(n, m));
    }

    public static void main(String[] args) {
        System.out.println(calcGCD(20, 15));
        System.out.println(calcGCD(11, 13));
    }
}
