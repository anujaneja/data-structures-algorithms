package com.anujaneja.algorithm.takeuforward.array.easy;

import java.util.Arrays;

public class SecondLargestAndSecondSmallest {
    public static int[] getSecondOrderElements(int n, int[] a) {
        // Write your code here.
        int l = Integer.MIN_VALUE;
        int sl = Integer.MIN_VALUE;
        int s = Integer.MAX_VALUE;
        int ss = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > l) {
                sl = l;
                l = a[i];
            } else if (a[i] != l) {
                if (a[i] > sl) {
                    sl = a[i];
                }
            }

            if (a[i] < s) {
                ss = s;
                s = a[i];
            } else if (a[i] != s) {
                if (a[i] < ss) {
                    ss = a[i];
                }
            }
        }
        int[] output = new int[2];
        output[0] = sl;
        output[1] = ss;
        return output;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 3, 4, 5, 5, 6, 7, 8, 10, 23, 10, 23};

        Arrays.stream(getSecondOrderElements(11, arr)).forEach(System.out::println);
    }
}
