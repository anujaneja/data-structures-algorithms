package com.anujaneja.algorithm;

public class MergeSort {

     static void merge(int[] arr,int start, int mid, int end) {
        int[] temp = new int[end-start+1];
        int tempIndex = 0;
        int i=start;
        int j=mid+1;

        while(i<=mid && j<=end) {
            if(arr[i]<=arr[j]) {
                temp[tempIndex] = arr[i];
                tempIndex++;
                i++;
            } else {
                temp[tempIndex] = arr[j];
                tempIndex++;
                j++;
            }
        }

        while (i<=mid) {
            temp[tempIndex] = arr[i];
            tempIndex++;
            i++;
        }

         while (j<=end) {
             temp[tempIndex] = arr[j];
             tempIndex++;
             j++;
         }

         // copy temp to original interval
         for(i = start; i <= end; i += 1) {
             arr[i] = temp[i - start];
         }
    }

    static void mergeSort(int[] arr, int start, int end) {
        if(start<end) {
            int mid = (start+end)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }

    public static void main(String[] args) {
        int[] arr= new int[] {10,9,8,7,5,4,3,2,1,6,8};
        mergeSort(arr,0,arr.length-1);

        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }

    }
}
