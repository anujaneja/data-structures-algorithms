package com.anujaneja.algorithm.takeuforward.array.easy;

import java.util.Arrays;

/*
Problem Link:

https://www.codingninjas.com/studio/problems/left-rotate-an-array-by-one_5026278
 */
public class RotateAnArrayByOne {

    static int[] rotateArray(int[] arr) {
        // Write your code here.
        int temp = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        nums = rotateArray(nums);

        Arrays.stream(nums).forEach(value -> System.out.print(value + ","));
    }
}
