package com.anujaneja.algorithm.takeuforward.array.medium;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {
    public static List<Integer> superiorElements(int[] a) {
        int maxi = Integer.MIN_VALUE;
        List<Integer> output = new ArrayList<>();
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] > maxi) {
                output.add(a[i]);
            }
            maxi = Math.max(maxi, a[i]);
        }

        return output;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 22, 12, 3, 0, 6};
        List<Integer> superiorElements = superiorElements(arr);
        superiorElements.forEach(value -> System.out.print(value + ","));
        System.out.println("\n------------------------------------------\n");
    }
}
