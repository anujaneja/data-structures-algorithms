package com.anujaneja.algorithm.educative.binarySearch;

class FindRange {

    public static int[] findRange(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[] { -1, -1 };

        result[0] = binarySearchModified(nums, target, false);

        if (result[0] != -1) {
            result[1] = binarySearchModified(nums, target, true);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }

    public static int binarySearchModified(int[] nums, int target, boolean findMaxIndex) {
        int start = 0, end = nums.length - 1;
        int keyIndex = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                //nums[mid]==target
                keyIndex = mid;

                if (findMaxIndex) {
                    //search ahead...
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return keyIndex;
    }
}