package com.anujaneja.algorithm.takeuforward.array.medium;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int l = nums.length;
        int breakPointIndex = -1;
        //first try to find the break-point index...
        for (int i = l - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakPointIndex = i;
                break;
            }
        }

        //if no break point found just reverse the array
        if (breakPointIndex == -1) {
            reverse(nums, 0, nums.length - 1);
        } else {
            // Search smallest number in the right half from i+1 to l-1
            //That should be just greater then nums[i]
            for (int i = l - 1; i > breakPointIndex; i--) {
                if (nums[i] > nums[breakPointIndex]) {
                    swap(nums, i, breakPointIndex);
                    break;
                }
            }

            reverse(nums, breakPointIndex + 1, l - 1);
        }


    }

    public int[] reverse(int[] nums, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }

        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{3, 2, 1};
        nextPermutation.nextPermutation(nums);
        Arrays.stream(nums).forEach(value -> System.out.print(value + ","));
        System.out.println("\n--------------------\n");

        nums = new int[]{1, 3, 2};
        nextPermutation.nextPermutation(nums);
        Arrays.stream(nums).forEach(value -> System.out.print(value + ","));
        System.out.println("\n--------------------\n");
    }
}
