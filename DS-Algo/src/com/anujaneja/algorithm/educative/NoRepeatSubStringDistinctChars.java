package com.anujaneja.algorithm.educative;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem statement:
 * https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 *
 */
public class NoRepeatSubStringDistinctChars {
    public static int longestSubStringDistinctChars(String str) {
        int windowStart=0;
        int max_length = 0;
        Map<Character,Integer> charactersMap = new HashMap<>();

        for(int windowEnd=0;windowEnd<str.length();windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            if(charactersMap.containsKey(rightChar)) {
                // whenever a repeated char is found we need to shrink the window from left to just one
                // point ahead of repeating charactor...
                windowStart = Math.max(windowStart,charactersMap.get(rightChar)+1);
            }

            //Just store the character index into the map...
            charactersMap.put(rightChar,windowEnd);
//            System.out.println("windowEnd ="+windowEnd+" windowStart="+windowStart);
            max_length = Math.max(max_length,(windowEnd-windowStart+1));
//            System.out.println("max_length="+max_length);

        }


        return max_length;
    }

    public static void main(String[] args) {
        String str = "aabccbb";
        int substringLength= longestSubStringDistinctChars(str);
        System.out.println("substringLength: "+substringLength);

        str= "dabcadehhabcdefghijklmn";
        substringLength = longestSubStringDistinctChars(str);
        System.out.println("substringLength: "+substringLength);
    }
}
