package com.anujaneja.algorithm.educative.cyclic_sort;

public class SmallestPositiveNumber {

    public static int smallestPositiveNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i]>0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1])
                swap(nums, i, nums[i]-1);
            else
                i++;
        }

        // find the first number missing from its index, that will be our required number
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i+1)
                return i+1;


        return nums.length+1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = new  int[]{-3,1,5,4,2};

        int smallestPositiveNumber = smallestPositiveNumber(nums);

        System.out.println("smallestPositiveNumber="+smallestPositiveNumber );

    }
}
