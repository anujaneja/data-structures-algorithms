package com.anujaneja.algorithm.educative.xor;

/**
 * Video explaination - https://www.youtube.com/watch?v=wPBKH1jy0_E
 * Medium - https://leetcode.com/problems/single-number-iii/
 */
public class TwoSingleNumbers {

    public static int[] findSingleNumbers_1(int[] nums) {
        // get the XOR of the all the numbers
        int n1xn2 = 0;
        for (int num : nums) {
            n1xn2 ^= num;
        }

        // get the rightmost bit that is '1'
        int rightmostSetBit = 1;
        while ((rightmostSetBit & n1xn2) == 0) {
            rightmostSetBit = rightmostSetBit << 1;
        }

        System.out.println("rightmostSetBit="+rightmostSetBit);

        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) != 0) // the bit is set
                num1 ^= num;
            else // the bit is not set
                num2 ^= num;
        }
        return new int[] { num1, num2 };
    }

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

        arr = new int[] { 1, 3, 4, 4,5,1 };
        result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);


    }
}
