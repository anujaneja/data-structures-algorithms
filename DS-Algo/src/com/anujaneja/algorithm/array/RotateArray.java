package com.anujaneja.algorithm.array;

/**
 * Created by anuj on 17/10/17.
 */
public class RotateArray {

    public void rotate(int arr[],int degree) {

        if(degree<1 || arr.length==0){
            return;
        }

        degree =  degree%arr.length;

        reverse(arr,0,degree-1);
        reverse(arr,degree,arr.length-1);
        reverse(arr,0,arr.length-1);

    }

    public void reverse(int arr[],int left, int right) {

       while(left<right) {
           int temp = arr[left];
           arr[left]= arr[right];
           arr[right] = temp;

           left++;
           right--;
       }

    }

    public static void printArrayElements(int arr[]){

        for(int i=0;i<arr.length;i++){
            if(i!=arr.length-1) {
                System.out.print(arr[i]+",");
            } else {
                System.out.println(arr[i]);
            }

        }
    }

    public static void main(String[] s) {
        int arr[] =new int[]{1,2,3,4,5,6};
        new RotateArray().rotate(arr,10);

        printArrayElements(arr);
    }
}
