package com.anujaneja.algorithm.educative;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctChars {

    public static int longestSubstringOfDistinctChars(String str,int k) {
        int max_length = 0;
        int windowStart=0;
        Map<Character,Integer> charactersFrequencies  = new HashMap<>();

        for(int windowEnd=0;windowEnd<str.length();windowEnd++) {
            Character rightChar = str.charAt(windowEnd);
            charactersFrequencies.put(rightChar,charactersFrequencies.getOrDefault(rightChar,0)+1);

            if(charactersFrequencies.size()<=k) {
                max_length = Math.max(max_length,(windowEnd-windowStart+1));
            }


            while(charactersFrequencies.size()>k) {
                //shrink the array...
                Character leftChar = str.charAt(windowStart);
                charactersFrequencies.put(leftChar,charactersFrequencies.get(leftChar)-1);

                if(charactersFrequencies.get(leftChar)==0) {
                    charactersFrequencies.remove(leftChar);
                }

                windowStart++;
            }
        }
        return max_length;
    }

    public static void main(String[] args) {
        int output = longestSubstringOfDistinctChars("araaci",2);

        System.out.println("output="+output);


        output = longestSubstringOfDistinctChars("araaci",1);

        System.out.println("output="+output);

        output = longestSubstringOfDistinctChars("araaci",3);

        System.out.println("output="+output);

    }
}
