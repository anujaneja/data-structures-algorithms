package com.anujaneja.algorithm.takeuforward.array.easy;

/**
 * https://leetcode.com/problems/missing-number/description/
 */
public class MissingNumberInArray {
    public int missingNumber(int[] nums) {

        int xor1 = 0;

        for(int i=0;i<nums.length+1;i++) {
            xor1 = i^xor1;
        }

        int xor2= 0;

        for(int i=0;i<nums.length;i++) {
            xor2 = nums[i]^xor2;
        }

        return xor2^xor1;
    }


}
