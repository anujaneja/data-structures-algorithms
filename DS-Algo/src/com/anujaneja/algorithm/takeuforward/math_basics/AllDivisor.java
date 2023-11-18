package com.anujaneja.algorithm.takeuforward.math_basics;

import java.util.ArrayList;
import java.util.List;

/*
    All Divisor
    Time Complexity: O(sqrt(n)*n) ~ O(m*n) where m sqrt of intermediate no.
 */
public class AllDivisor {
    public static List<Integer> allDivisors(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                if (n / i != i) {
                    factors.add(n / i);
                }
            }

        }
        return factors;
    }

    public static int sumOfAllDivisors(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += allDivisors(i).stream().mapToInt(value -> value).sum();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(allDivisors(3));
        System.out.println(sumOfAllDivisors(36));
    }
}
