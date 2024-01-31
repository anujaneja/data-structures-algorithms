package com.anujaneja.algorithm.takeuforward.array.easy;

import java.util.Arrays;

/*
    https://leetcode.com/problems/move-zeroes/submissions/1146117847/
 */
class MoveZerosToEnd {
    public static void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 2, 3, 0, 4, 0, 1,};

        moveZeroes(nums);

        Arrays.stream(nums).forEach(value -> System.out.print(value + ", "));

    }

}