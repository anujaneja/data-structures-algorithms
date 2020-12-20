package com.anujaneja.algorithm.educative;

/**
 * Problem Statement:
 * https://leetcode.com/problems/fruit-into-baskets/
 */
public class FruitsBasketsProblem {


    public static void main(String[] args) {
        char[] fruits = new char[]{'A','B','C','A','C'};

        int maxNoOfFruits = LongestSubstringWithKDistinctChars.longestSubstringOfDistinctChars(new String(fruits),2);
        System.out.println("Max no. of fruits: "+maxNoOfFruits);

        fruits = new char[]{'A','B','C','B','B','C'};

        maxNoOfFruits = LongestSubstringWithKDistinctChars.longestSubstringOfDistinctChars(new String(fruits),2);
        System.out.println("Max no. of fruits: "+maxNoOfFruits);
    }
}
