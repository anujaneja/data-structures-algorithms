package com.anujaneja.algorithm.takeuforward.array.easy;

/*

 */
public class ArraySortedAndRotated {

    public static boolean check(int[] nums) {
        int peakPoint = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length]) {
                peakPoint++;
            }

            if (peakPoint > 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 2};

        boolean isSortedAndRotated = check(arr);
        System.out.println("isSortedAndRotated = " + isSortedAndRotated);

        arr = new int[]{1, 2, 3, 4};

        isSortedAndRotated = check(arr);
        System.out.println("isSortedAndRotated = " + isSortedAndRotated);
    }
}
