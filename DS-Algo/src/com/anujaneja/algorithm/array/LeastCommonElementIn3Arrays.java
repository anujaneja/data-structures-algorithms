package com.anujaneja.algorithm.array;

import java.util.ArrayList;

/**
 * Created by anuj on 16/10/17.
 */
public class LeastCommonElementIn3Arrays {

    public int findLeastCommonElementIn3Arrays(int arr1[],int arr2[],int arr3[]) {

        int leastCommonElement = -1;
        ArrayList<Integer> commonArrayList = new ArrayList<Integer>();

        for(int i=0,j=0,k=0;(i<arr1.length || j<arr2.length || k<arr3.length);) {
//            System.out.println("i="+i+" j="+j+" k="+k);

            if(i==arr1.length || j==arr2.length || k==arr3.length) {
                break;
            }

            if(arr1[i]==arr2[j] && arr2[j]==arr3[k]) {
                commonArrayList.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if(arr1[i] < arr2[j]) {
                i++;
            } else if(arr1[i] > arr2[j]){
                j++;
            }else if (arr2[j] <arr3[k]) {
                j++;
            } else if(arr2[j]>arr3[k]) {
                k++;
            }
        }

        System.out.println(commonArrayList);

        leastCommonElement = commonArrayList.get(0);
        return leastCommonElement;
    }

    public static void main(String[] s) {
        int arr1[] = new int[]{1,2,3,4,12,17};
        int arr2[] = new int[]{1,2,4,5,7,9,11,12,17};
        int arr3[] = new int[]{1,2,3,4,5,6,12,17};

        LeastCommonElementIn3Arrays leastCommonElementIn3Arrays = new LeastCommonElementIn3Arrays();
        int leastCommonElement = leastCommonElementIn3Arrays.findLeastCommonElementIn3Arrays(arr1,arr2,arr3);


        System.out.println("Least common element is: "+leastCommonElement);
    }
}
