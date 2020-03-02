package com.anujaneja.algorithm;

public class QuickSort {

    public static void quickSort(int[] arr, int start,int end) {
        if(start<end) {
            int pIndex = partition(arr,start,end);
            quickSort(arr,start,pIndex-1);
            quickSort(arr,pIndex+1,end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = start;

        for(int i=start;i<end;i++) {
            if(arr[i]<=pivot) {
                System.out.println("arr[i] "+arr[i]+" arr[pIndex+1] "+arr[pIndex+1]);
                swap(arr,i,pIndex);
                System.out.println("arr[i] "+arr[i]+" arr[pIndex+1] "+arr[pIndex+1]);
                pIndex++;
            }
        }
        swap(arr,pIndex,end);
        return pIndex;

    }

    private static void swap(int[] arr,int i, int j) {
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

    public static void main(String[] args) {
        int[] arr= new int[] {10,9,8,7,5,4,3,2,1,6,8};
        quickSort(arr,0,arr.length-1);

        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}
