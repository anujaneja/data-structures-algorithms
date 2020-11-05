package com.anujaneja.algorithm.array;

public class BinarySearchIterative {

    public static int binarySearch(int[] arr, int element, int low, int high) {

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == element) {
                return mid;
            }

            if(element<arr[mid]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 5, 6, 7, 9, 10, 12, 14, 20, 22, 25 };
        int element = 25;
        int index = binarySearch(arr, element, 0, arr.length - 1);

        if (index >= 0) {
            System.out.println(element + " Found at index: " + index);
        } else {
            System.out.println(element + " Not Found");
        }
    }
}
