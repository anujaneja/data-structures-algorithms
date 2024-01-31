package com.anujaneja.algorithm.takeuforward.array.easy;

/**
 * https://leetcode.com/problems/max-consecutive-ones/
 */
public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int c=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==1) {
                c++;
                max1 = Math.max(c,max1);
            } else {
                c=0;
                max1 = Math.max(c,max1);
            }

        }

        return max1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,0,1,1,1,1,0,1,1,1};
        int k = findMaxConsecutiveOnes(nums);

        System.out.println(k);

    }
}
