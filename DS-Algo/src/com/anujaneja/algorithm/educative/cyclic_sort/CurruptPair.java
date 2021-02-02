package com.anujaneja.algorithm.educative.cyclic_sort;

import java.util.Arrays;

public class CurruptPair {

    static int[] findMissingAndDuplicate(int[] nums) {
        if(nums.length<2) {
            return new int[]{};
        }

        int[] result = new int[2];

        int i =0;

        while (i<nums.length) {
            int abs_num = Math.abs(nums[i]);

            if (nums[abs_num - 1] > 0) {
                nums[abs_num - 1] = -nums[abs_num - 1];
            } else {
                result[0] = abs_num;
            }

            i++;
        }

            i=0;

            while(i<nums.length) {
                if(nums[i]>0) {
                    result[1] = i+1;
                    break;
                }

                i++;
            }


        return result;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{2,1,2,4,3};

        System.out.println("REsult = "+ Arrays.toString(findMissingAndDuplicate(nums)));

    }
}
