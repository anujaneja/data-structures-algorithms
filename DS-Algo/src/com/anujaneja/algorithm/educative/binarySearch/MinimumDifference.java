package com.anujaneja.algorithm.educative.binarySearch;


class MinimumDifference {

  public static int searchMinDiffElement(int[] arr, int key) {
    int start=0;
    int end=arr.length-1;

    while(start<=end) {
      int mid= start+(end-start)/2;

      if(arr[mid]>key) {
        end=mid-1;
      } else if(arr[mid]<key) {
        start=mid+1;
      } else {
        //equal...to mid element...
        return arr[mid];
      }


      if((arr[start]-key)>(arr[end]-key)) {
        return arr[end];
      } else {
        return arr[start];
      }

    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
    System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
  }
}