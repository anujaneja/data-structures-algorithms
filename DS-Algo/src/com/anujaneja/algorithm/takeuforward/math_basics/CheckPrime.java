package com.anujaneja.algorithm.takeuforward.math_basics;

/*
    Check for Prime No
    https://www.codingninjas.com/studio/problems/check-prime_624934?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
    Time Complexity: O(sqrt(n)) ~ O(k)

 */
public class CheckPrime {

    public static boolean isPrime(int n) {
        if (n >= 1) {
            int factorCnt = 2;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    factorCnt++;
                }
            }
            return factorCnt == 2;
        }
        return false;
    }

    public static void main(String[] args) {
        int no = 1;
        System.out.println(no + " isPrime =>  " + isPrime(no));
        no = 2;
        System.out.println(no + " isPrime =>  " + isPrime(no));
        no = 3;
        System.out.println(no + " isPrime =>  " + isPrime(no));
        no = 5;
        System.out.println(no + " isPrime =>  " + isPrime(no));
        no = 7;
        System.out.println(no + " isPrime =>  " + isPrime(no));
        no = 11;
        System.out.println(no + " isPrime =>  " + isPrime(no));
        no = 8;
        System.out.println(no + " isPrime =>  " + isPrime(no));
        no = 10;
        System.out.println(no + " isPrime =>  " + isPrime(no));
        no = 111;
        System.out.println(no + " isPrime =>  " + isPrime(no));
        no = 22;
        System.out.println(no + " isPrime =>  " + isPrime(no));
    }
}
