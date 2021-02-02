package com.anujaneja.algorithm.educative.cyclic_sort;

/**
 * Easy - 1 to n number sorting based on the index...
 */
public class CyclicSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int i = 0;

        while (i < nums.length) {
            if (nums[i] == i + 1) {
                i++;
            } else {
                swap(nums, i, (nums[i] - 1));
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 5, 4, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 6, 4, 3, 1, 5 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 1, 5, 6, 4, 3, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] {};
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = null;
        CyclicSort.sort(arr);

        if (arr != null) {
            for (int num : arr)
                System.out.print(num + " ");
            System.out.println();
        }

    }
}
