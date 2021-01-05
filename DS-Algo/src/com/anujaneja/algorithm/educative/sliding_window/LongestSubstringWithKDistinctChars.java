package com.anujaneja.algorithm.educative.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class LongestSubstringWithKDistinctChars {

    public static int longestSubstringOfDistinctInteger(int[] arr,int k) {
        int max_length = 0;
        int windowStart=0;
        Map<Integer,Integer> charactersFrequencies  = new HashMap<>();

        for(int windowEnd=0;windowEnd<arr.length;windowEnd++) {
            int rightNumber= arr[windowEnd];
            charactersFrequencies.put(rightNumber,charactersFrequencies.getOrDefault(rightNumber,0)+1);




            while(charactersFrequencies.size()>k) {
                //shrink the array...
                int leftNumber= arr[windowStart];
                charactersFrequencies.put(leftNumber,charactersFrequencies.get(leftNumber)-1);

                if(charactersFrequencies.get(leftNumber)==0) {
                    charactersFrequencies.remove(leftNumber);
                }

                windowStart++;
            }

            if(charactersFrequencies.size()<=k) {
                max_length = Math.max(max_length,(windowEnd-windowStart+1));
            }
        }
        return max_length;
    }

    public static int longestSubstringOfDistinctChars(String str,int k) {
        int max_length = 0;
        int windowStart=0;
        Map<Character,Integer> charactersFrequencies  = new HashMap<>();

        for(int windowEnd=0;windowEnd<str.length();windowEnd++) {
            Character rightChar = str.charAt(windowEnd);
            charactersFrequencies.put(rightChar,charactersFrequencies.getOrDefault(rightChar,0)+1);




            while(charactersFrequencies.size()>k) {
                //shrink the array...
                Character leftChar = str.charAt(windowStart);
                charactersFrequencies.put(leftChar,charactersFrequencies.get(leftChar)-1);

                if(charactersFrequencies.get(leftChar)==0) {
                    charactersFrequencies.remove(leftChar);
                }

                windowStart++;
            }

            if(charactersFrequencies.size()<=k) {
//                System.out.println(str.substring(windowStart,windowEnd+1));
                max_length = Math.max(max_length,(windowEnd-windowStart+1));
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

        int[] tree = new int[]{14,14,1,1,14,5,14,1,14,1,5,5,1,24,7,7,8,7,7,12,12,8,23,8,23,8,20,10,0,17};
        output = longestSubstringOfDistinctInteger(tree,2);

        System.out.println("output="+output);

        //expected 1
        tree = new int[]{0};
        output = longestSubstringOfDistinctInteger(tree,2);

        System.out.println("output="+output);

    }
}
