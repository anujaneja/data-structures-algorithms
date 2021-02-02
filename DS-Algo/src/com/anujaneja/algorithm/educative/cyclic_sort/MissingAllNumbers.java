package com.anujaneja.algorithm.educative.cyclic_sort;

import java.util.ArrayList;

public class MissingAllNumbers {

    public static ArrayList<Integer> missingAllNumbersCS(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i]-1])
                swap(nums, i, nums[i]-1);
            else
                i++;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        // find the first number missing from its index, that will be our required number
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i+1)
                 arrayList.add(i+1);

        //To handle the edge case if last number is missing...
        return arrayList;

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 1, 1 };

        ArrayList<Integer> missingNumbers = missingAllNumbersCS(nums);
        System.out.println("missingNumbers=" + missingNumbers);

        nums = new int[] { 1,1,2};

        missingNumbers = missingAllNumbersCS(nums);
        System.out.println("missingNumbers=" + missingNumbers);
    }
}
