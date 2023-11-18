package com.anujaneja.algorithm.takeuforward.math_basics;

import java.util.Scanner;

/*
    Armstrong number
    Time complexity
        O(log(n))

   Link: https://www.codingninjas.com/studio/problems/check-armstrong_589?utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION
 */
public class ArmstrongNumber {

    public static boolean checkArmstrong(int n) {
        //Write your code here
        int i = Math.abs(n);
        int sum = 0;
        int cnt = 0;
        while (i > 0) {
            // System.out.println("i=="+i);
            cnt++;
            i = i / 10;

        }

        // System.out.println(cnt);
        i = n;
        while (i > 0) {
            int lastDigit = i % 10;
            sum = sum + (int) Math.pow(lastDigit, cnt);
            i = i / 10;
        }

        return sum == n;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();


        if (checkArmstrong(n)) {

            System.out.println("true");

        } else {

            System.out.println("false");

        }

    }
}
