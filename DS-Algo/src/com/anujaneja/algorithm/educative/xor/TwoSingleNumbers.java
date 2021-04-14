package com.anujaneja.algorithm.educative.xor;

/**
 * Video explaination - https://www.youtube.com/watch?v=wPBKH1jy0_E
 * Medium - https://leetcode.com/problems/single-number-iii/
 */
public class TwoSingleNumbers {

    public static int[] findSingleNumbers(int[] nums) {

        int XxY = nums[0];

        for (int i = 1; i < nums.length; i++) {
            XxY = XxY ^ nums[i];
        }

        int rightSigDigit = XxY & (-XxY);
        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if((rightSigDigit & nums[i])==0) {
                num1= num1^nums[i];
            } else {
                num2= num2^nums[i];
            }
        }

        return new int[]{num1,num2};
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 4, 2, 1, 3, 5, 6, 2, 3, 5 };
        int[] result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);

        arr = new int[] { 2, 1, 3, 2 };
        result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);
    }
}
