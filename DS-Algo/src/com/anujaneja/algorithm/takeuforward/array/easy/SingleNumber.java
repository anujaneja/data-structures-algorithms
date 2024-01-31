package com.anujaneja.algorithm.takeuforward.array.easy;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int xor1 = 0;
        for (int i = 0; i < nums.length; i++) {
            xor1 = nums[i] ^ xor1;
        }

        return xor1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5, 6, 6, 7, 7};
        int k = singleNumber(nums);

        System.out.println(k);
    }
}
