package com.anujaneja.algorithm.educative;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/submissions/
 */
public class FindAllAnagramsOfStr {

    /**
     * Little in-efficient....
     * checking for match...when window size match with pattern length...takes
     * constant amount of time...
     */

    public static ArrayList<Integer> isPermutationOfStringPresent(String str, String pattern) {
        if (str.length()<pattern.length()) {
            return new ArrayList<>();
        }

        ArrayList<Integer> permutationIndexes = new ArrayList<>();

        HashMap<Character, Integer> patternFreqMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character character = pattern.charAt(i);
            patternFreqMap.put(character, patternFreqMap.getOrDefault(character, 0) + 1);
        }

        int windowStart = 0;
        HashMap<Character, Integer> windowFreqMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            Character charRight = str.charAt(windowEnd);
            windowFreqMap.put(charRight, windowFreqMap.getOrDefault(charRight, 0) + 1);

            //            System.out.println("char: " + charRight + patternFreqMap);
            if ((windowEnd - windowStart + 1) > pattern.length()) {
                //                System.out.println("Shrinking the window by 1 : ");
                Character rightChar = str.charAt(windowStart);
                windowFreqMap.put(rightChar, windowFreqMap.get(rightChar) - 1);

                if (windowFreqMap.get(rightChar) == 0) {
                    windowFreqMap.remove(rightChar);
                }

                windowStart++;
            }

            //checking for match...when window size match with pattern length...
            if (pattern.length() == (windowEnd - windowStart + 1)) {
                //                System.out.println("Size matched : "+str.substring(windowStart,windowEnd+1));
                boolean windowMatch = true;

                for (Map.Entry<Character, Integer> entry : patternFreqMap.entrySet()) {
                    Character c = entry.getKey();
                    if (!entry.getValue().equals(windowFreqMap.get(c))) {
                        windowMatch = false;
                    }
                }

                if (windowMatch) {
                    permutationIndexes.add(windowStart);
                }
            }
        }

        return permutationIndexes;
    }

    public static void main(String[] args) {
        String str = "ppqp";
        String pattern = "pq";

        System.out.println("pattern found: " + isPermutationOfStringPresent(str, pattern));


        str = "abbcabc";
        pattern = "abc";

        System.out.println("pattern found: " + isPermutationOfStringPresent(str, pattern));


    }
}
