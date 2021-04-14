package com.anujaneja.algorithm.educative.xor;

/**
 * Easy - https://leetcode.com/problems/flipping-an-image/
 */
class FlipAndInvertImage {
    public static int[][] flipAndInvertImage(int[][] arr) {

        int columns = arr[0].length;
        for (int[] row : arr) {
            for (int i = 0; i < (columns + 1) / 2; i++) {
                int temp = row[i] ^ 1;
                row[i] = row[columns - 1 - i] ^ 1;
                row[columns - 1 - i] = temp;
            }
        }

        return arr;
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 0, 1 }, { 1, 1, 1 }, { 0, 1, 1 } };
        print(flipAndInvertImage(arr));

        int[][] arr2 = { { 1, 1, 0, 0 }, { 1, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 0, 1, 0 } };
        print(flipAndInvertImage(arr2));
    }
}