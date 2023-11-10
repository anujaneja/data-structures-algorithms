package com.anujaneja.algorithm.takeuforward.math_basics;

import java.util.HashMap;
import java.util.Map;

public class CountDigits {
    static int countDigit(long x) {
        // Write your code here.
        int c = 0;
        while (x > 0) {
            //digit = x%10;
            x = x / 10;
            c++;

        }

        return c;
    }

    public static void main(String[] args) {
        Map<Long, Long> inputToOutputMap = new HashMap<>();
        inputToOutputMap.put(78l, 2l);
        inputToOutputMap.put(37l, 2l);
        inputToOutputMap.put(7l, 1l);
        inputToOutputMap.put(444l, 3l);
        inputToOutputMap.put(4460l, 4l);
        inputToOutputMap.put(0l, 1l);

        inputToOutputMap.forEach((n1, n2) -> {
                    long x = countDigit(n1);
                    System.out.println(x);
                    boolean b = n2 == x;
                    System.out.println(b);
                }

        );

    }
}
