package com.anujaneja.algorithm.educative.top_elements;

import java.util.*;

class Entry {
    int key;
    int value;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Medium - https://leetcode.com/problems/find-k-closest-elements/
 *
 */
class KClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
        List<Integer> result = new ArrayList<>();
        int index = binarySearch(arr, X);
        System.out.println("index="+index);

        int leftIndex = index;
        int rightIndex = index + 1;

        for (int i = 0; i < K; i++) {
            if (leftIndex >= 0 && rightIndex < arr.length) {
                int diffL = Math.abs(X - arr[leftIndex]);
                int diffR = Math.abs(X - arr[rightIndex]);

                if (diffL <= diffR) {
                    result.add(0,arr[leftIndex--]);
                } else {
                    result.add(arr[rightIndex++]);
                }

            } else if (leftIndex >= 0) {
                result.add(0,arr[leftIndex--]);
            } else if (rightIndex < arr.length) {
                result.add(arr[rightIndex++]);
            }
        }

        //No need to sort because we are having prority on
        // leftIndex first...

        //Collections.sort(result);

        return result;
    }

    public static int binarySearch(int[] arr, int X) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == X) {
                return mid;
            } else if (arr[mid] > X) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (low > 0) {
            low = low - 1;
        }

        return low;
    }

    public static void main(String[] args) {
        List<Integer> result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
//        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 ,10,11,12}, 3, 7);
        System.out.println("'K' closest numbers to 'X' are: " + result);

//        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
//        System.out.println("'K' closest numbers to 'X' are: " + result);
    }
}