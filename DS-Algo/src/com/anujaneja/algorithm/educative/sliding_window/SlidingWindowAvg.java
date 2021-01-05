package com.anujaneja.algorithm.educative.sliding_window;

/**
 * Problem Statement:
 * Easy - https://www.geeksforgeeks.org/program-find-simple-moving-average/
 */
public class SlidingWindowAvg {

    //Non-efficient
    private static double[] findAvgsNE(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1];
        int index = 0;

        for (int i = 0; i < (arr.length - k + 1); i++) {
            double sum = 0;

            for (int j = i; j < (i + k); j++) {
                sum += arr[j];
            }

            result[index] = sum / k;
            index++;
        }

        return result;
    }

    //efficient
    private static double[] findAvgsE(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1];
        int index = 0;
        double sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        result[index++] = sum / k;

        for (int i = k; i <=(arr.length - k +1); i++) {
            sum = sum - arr[i - k] + arr[i];
            result[index++] = sum / k;
        }

        sum = 0;

        for (int i = (arr.length - k ); i < arr.length; i++) {
            sum += arr[i];
        }

        result[index] = sum / k;

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 };

        double[] result = findAvgsE(3, arr);

        for (double element : result) {
            System.out.println(element);
        }
    }
}
