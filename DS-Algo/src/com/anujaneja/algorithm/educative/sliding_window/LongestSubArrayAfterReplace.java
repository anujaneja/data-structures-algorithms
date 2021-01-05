package com.anujaneja.algorithm.educative.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Educative - Grokking Coding Interview - Pattens for coding - No. 9
 * Medium  -  https://leetcode.com/problems/longest-repeating-character-replacement/
 */
public class LongestSubArrayAfterReplace {

    public static int find(String str,int k) {
        int windowStart=0;
        int max_length = 0;
        Map<Character,Integer> charactersMap = new HashMap<>();
        int maxRepeatCharCount = 0;

        for(int windowEnd=0;windowEnd<str.length();windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charactersMap.put(rightChar,charactersMap.getOrDefault(rightChar,0)+1);
            maxRepeatCharCount = Math.max(maxRepeatCharCount,charactersMap.get(rightChar));

            while(windowEnd-windowStart+1-maxRepeatCharCount>k) {
                //Shrink the window...
                Character leftChar = str.charAt(windowStart);
                charactersMap.put(leftChar,charactersMap.get(leftChar)-1);
                windowStart++;
            }

            max_length = Math.max(max_length,(windowEnd-windowStart+1));
        }


        return max_length;
    }

    public static void main(String[] args) {
        String str = "aabccbb";
        int substringLength= find(str,2);
        System.out.println("substringLength: "+substringLength);

        str = "abbcb";
        substringLength= find(str,1);
        System.out.println("substringLength: "+substringLength);

        str = "abccde";
        substringLength= find(str,1);
        System.out.println("substringLength: "+substringLength);

        str = "abbcbbc";
        substringLength= find(str,2);
        System.out.println("substringLength: "+substringLength);

    }
}
