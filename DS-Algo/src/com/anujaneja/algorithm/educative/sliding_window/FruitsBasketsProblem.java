package com.anujaneja.algorithm.educative.sliding_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Problem Statement:
 * Medium - https://leetcode.com/problems/fruit-into-baskets/
 */
public class FruitsBasketsProblem {


    public static void main(String[] args) {
        char[] fruits = new char[]{'A','B','C','A','C'};

        int maxNoOfFruits = LongestSubstringWithKDistinctChars.longestSubstringOfDistinctChars(new String(fruits),2);
        System.out.println("Max no. of fruits: "+maxNoOfFruits);

        fruits = new char[]{'A','B','C','B','B','C'};

        maxNoOfFruits = LongestSubstringWithKDistinctChars.longestSubstringOfDistinctChars(new String(fruits),2);
        System.out.println("Max no. of fruits: "+maxNoOfFruits);

        int[] tree = new int[]{14,14,1,1,14,5,14,1,14,1,5,5,1,24,7,7,8,7,7,12,12,8,23,8,23,8,20,10,0,17};
        maxNoOfFruits = LongestSubstringWithKDistinctChars.longestSubstringOfDistinctInteger(tree,2);
        System.out.println("Max no. of fruits: "+maxNoOfFruits);
    }
}
