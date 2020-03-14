package com.anujaneja.algorithm.array;

public class BubbleSort {

    public static  void bubbleSort(int[] arr) {
        boolean isDone=false;
        int counter = 0;
        while(!isDone) {
            isDone=true;
            int i=0;
            while (i<arr.length-counter-1) {
                if(arr[i]>arr[i+1]) {
                    swap(arr,i,i+1);
                    isDone=false;
                }

                i++;
            }
            counter++;
        }
    }

    private static void swap(int[] arr,int i, int j) {
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

    public static void main(String[] args) {
        int[] arr = new int[1000];

        for(int i=arr.length;i>=1;i--) {
            arr[i-1]=i;
        }

        bubbleSort(arr);
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}
