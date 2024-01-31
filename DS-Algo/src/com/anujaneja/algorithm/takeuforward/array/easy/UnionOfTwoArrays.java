package com.anujaneja.algorithm.takeuforward.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.codingninjas.com/studio/problems/sorted-array_6613259
 */
public class UnionOfTwoArrays {

    public static List<Integer> unionOfTwoArray(int[] a, int[] b) {
        ArrayList<Integer> out = new ArrayList<>();
        int i = 0;
        int j = 0;
        int last = 0;

        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                if (b[j] != last || out.size() == 0) {
                    out.add(b[j]);
                    last = b[j];
                }
                j++;
            } else {
                if (a[i] != last || out.size() == 0) {
                    out.add(a[i]);
                    last = a[i];
                }

                i++;
            }
        }


        while (i < a.length) {
            if (last != a[i]) {
                out.add(a[i]);
                last = a[i];
            }

            i++;
        }

        while (j < b.length) {
            if (last != b[j]) {
                out.add(b[j]);
                last = b[j];
            }

            j++;
        }

        return out;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{2, 3, 4, 4, 5};
        List<Integer> out = unionOfTwoArray(arr1, arr2);

        System.out.println(out);


    }
}
