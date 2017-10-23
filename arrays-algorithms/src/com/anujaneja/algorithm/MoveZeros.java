package com.anujaneja.algorithm;

/**
 * Given an integer array,
 * move all elements containing '0' to the left while maintaining the order of other elements in the array.

 */
public class MoveZeros {

    public static void printArrayElements(int arr[]){

        for(int i=0;i<arr.length;i++){
            if(i!=arr.length-1) {
                System.out.print(arr[i]+",");
            } else {
                System.out.println(arr[i]);
            }

        }
    }

    public static int[] moveZerosToRight(int[] arr) {

        int temp = 0;

        for(int j=0;j<arr.length;j++) {

            if(arr[j]==0) {
                continue;
            }

            if(arr[j]!=0) {
                arr[temp++]=arr[j];
            }
        }



        int i=arr.length-1;
        //Zero element count
        temp = arr.length-1-temp;

        while(temp>0) {
            arr[i--]=0;
            temp--;
        }

        return arr;
    }

    public static int[] moveZerosToLeft(int[] arr) {

        int temp =arr.length-1;

        for(int j=arr.length-1;j>0;j--) {

            if(arr[j]==0) {
                continue;
            }

            if(arr[j]!=0) {
                arr[temp--]=arr[j];
            }
        }



        int i=0;
        while(i<=temp && temp!=0) {
            arr[i++]=0;
        }

        return arr;
    }

    public static void main(String[] s) {
        int []arr = new int[]{0,1,2,0,0,0,4,3,0,5,0,0,0,4,3};
//        int []arr = new int[]{0,0,0,0,0,0,0,0};
//        int []arr = new int[]{1,2,4,3,7,4,5,3};

        int[] out = moveZerosToLeft(arr);
        printArrayElements(out);

        out = moveZerosToRight(arr);

        printArrayElements(out);

    }
}
