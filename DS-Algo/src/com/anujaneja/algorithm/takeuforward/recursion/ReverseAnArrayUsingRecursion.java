package com.anujaneja.algorithm.takeuforward.recursion;

/*
    1. Time Complexity: O(n/2) -> Exponential Time complexity
    2. Space Complexity: Stack space for function calls...
    https://www.codingninjas.com/studio/problems/reverse-an-array_8365444
 */
public class ReverseAnArrayUsingRecursion {

    public static int[] reverseArray(int[] arr, int i, int j) {
        if (i >= j) {
            return arr;
        }
        swap(arr, i, j);
        return reverseArray(arr, i + 1, j - 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 5, 7, 8, 9, 10};
        arr = reverseArray(arr, 0, arr.length - 1);

        for (int n : arr) {
            System.out.println(n);
        }

        arr = new int[]{1, 3, 5, 7, 8, 9, 10};
        arr = reverseArray(arr, 0, arr.length - 1);

        for (int n : arr) {
            System.out.println(n);
        }
    }
}
