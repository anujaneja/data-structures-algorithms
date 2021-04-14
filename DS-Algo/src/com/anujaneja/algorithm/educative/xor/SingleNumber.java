package com.anujaneja.algorithm.educative.xor;

/**
 * Easy - https://leetcode.com/problems/single-number/
 * Alternative approach to use HashMap and remove the element if already present in the hashmap
 * The one left in the array would be the answer
 * But, Space Complexity: O(n) and time Complexity: O(n)
 */
class SingleNumber {
    public static int findSingleNumber(int[] nums) {
        int num = 0;

        for (int i = 0; i < nums.length; i++) {
            num = num ^ nums[i];
        }

        return num;
    }

    public static void main(String args[]) {
        System.out.println(findSingleNumber(new int[] { 1, 4, 2, 1, 3, 2, 3 }));
    }
}