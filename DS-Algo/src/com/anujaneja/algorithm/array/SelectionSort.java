package com.anujaneja.algorithm.array;

public class SelectionSort {

    static void selectionSort(int[] arr) {


        for(int i=0;i<arr.length-1;i++) {
            int min_index = i;

            for(int j=i+1;j<arr.length;j++) {
                if(arr[j]<arr[min_index]){
                    min_index=j;
                }
            }
            swap(arr,i,min_index);
        }

    }

    private static void swap(int[] arr,int i, int j) {
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }


    public static void main(String[] args) {
        int[] arr = new int[] {1,2,5,8,7,3,5,4,1,3,34,5,18 };

        selectionSort(arr);

        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}


