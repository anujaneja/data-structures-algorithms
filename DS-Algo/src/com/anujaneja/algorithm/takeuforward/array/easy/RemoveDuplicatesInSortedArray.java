package com.anujaneja.algorithm.takeuforward.array.easy;

public class RemoveDuplicatesInSortedArray {

    public static int removeDuplicates(int[] nums) {
        int i=0;
        for(int j=0;j<nums.length;j++) {
            if(nums[j]!=nums[i]) {
                nums[i+1]=nums[j];
                i++;
            }

        }

        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,2,3,3,3};

        int k = removeDuplicates(nums);

        System.out.println(k);
    }
}
