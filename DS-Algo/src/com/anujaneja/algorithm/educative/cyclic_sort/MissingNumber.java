package com.anujaneja.algorithm.educative.cyclic_sort;

/**
 * Easy - https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return (nums.length * (nums.length + 1) / 2) - sum;
    }

    public static int missingNumberCS(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]])
                swap(nums, i, nums[i]);
            else
                i++;
        }

        // find the first number missing from its index, that will be our required number
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i)
                return i;

        //To handle the edge case if last number is missing...
        return nums.length;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 0, 1 };

        int missingNumer = missingNumberCS(nums);
        System.out.println("missingNumer=" + missingNumer);

        nums = new int[] { 0,1,2};

        missingNumer = missingNumberCS(nums);
        System.out.println("missingNumer=" + missingNumer);
    }
}
