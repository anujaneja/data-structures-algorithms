package com.anujaneja.algorithm.educative.two_pointer;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int i=0;

        for(int j=1;j<nums.length;j++) {
            if(nums[i]!=nums[j]) {
                nums[i+1]=nums[j];
                i++;
            }
        }


        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};

        System.out.println("removeDuplicates length: "+removeDuplicates(nums));

    }
}
