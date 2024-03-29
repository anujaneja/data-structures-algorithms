package com.anujaneja.algorithm.takeuforward.math_basics;

import java.util.ArrayList;
import java.util.List;

/*
    Time complexity - O(k) where k is the number of digits
 */
public class ReverseNumber {
    static int reverseNumber(int x) {
        int reverse_num = 0;
        int i = Math.abs(x);
        while (i > 0) {
            if (Integer.MAX_VALUE / 10 < Math.abs(reverse_num)) {
                reverse_num = 0;
                break;
            }
            reverse_num = reverse_num * 10 + i % 10;
            i = i / 10;

        }

        return x < 0 ? -reverse_num : reverse_num;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(11);
        numbers.add(12);
        numbers.add(13);
        numbers.add(155);
        numbers.add(1534236469);
        numbers.add(109009);
        numbers.add(-199090);
        numbers.add(0);
        numbers.forEach(num -> {
            System.out.println(reverseNumber(num));
        });

    }
}
