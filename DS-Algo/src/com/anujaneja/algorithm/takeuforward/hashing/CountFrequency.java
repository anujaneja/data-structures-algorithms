package com.anujaneja.algorithm.takeuforward.hashing;

/*
    Link: https://www.codingninjas.com/studio/problems/count-frequency-in-a-range_8365446?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
 */
public class CountFrequency {
    public static int[] countFrequency(int n, int x, int[] nums) {
        // Write your code here.
        int[] freqArr = new int[n];
        for (int num : nums) {
            if (num <= n) {
                freqArr[num - 1]++;
            }

        }

        return freqArr;
    }

    public static void main(String[] args) {
        /*
            10 14
            11 14 8 3 12 14 1 7 4 3
         */
        int[] freqArr = countFrequency(10, 14, new int[]{11, 14, 8, 3, 12, 14, 1, 7, 4, 3});

        for (int num : freqArr) {
            System.out.print(num+" , ");
        }
    }
}
