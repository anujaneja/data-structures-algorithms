package com.anujaneja.algorithm.takeuforward.array.easy;

public class MaxElement {

    public static int maxElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 17, 10, 18, 55, 34, 67, -1, -2, 8};
        int max = maxElement(arr);
        System.out.println("Max element: " + max);
    }
}
