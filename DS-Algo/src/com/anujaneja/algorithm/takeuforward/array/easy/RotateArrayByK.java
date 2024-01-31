package com.anujaneja.algorithm.takeuforward.array.easy;

import java.util.Arrays;

/*
    Problem Link: https://leetcode.com/problems/rotate-array/description/
 */
public class RotateArrayByK {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, n - k, n - 1);//reverse last k element.
        reverse(nums, 0, n - k - 1);
        reverse(nums, 0, n - 1);
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};

        rotate(nums, 3);

        Arrays.stream(nums).forEach(value -> System.out.print(value + ","));

    }

}
