package com.anujaneja.algorithm;

public class InsertionSort {

    public static int[] insertionSort(int[] arr) {
        int key = 0;
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1;
            System.out.println("key="+key);

            while (j >= 0 && arr[j] > key) {
                System.out.println("key="+key+" j="+j+" arr[j]="+arr[j]);
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{25, 17, 31, 13, 2};

        int[] sortedArr = insertionSort(arr);

        for(int i=0;i<sortedArr.length;i++) {
            System.out.println(sortedArr[i]);
        }
    }
}

