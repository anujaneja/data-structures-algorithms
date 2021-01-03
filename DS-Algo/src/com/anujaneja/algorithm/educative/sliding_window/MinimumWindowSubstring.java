package com.anujaneja.algorithm.educative.sliding_window;

import java.util.HashMap;

public class MinimumWindowSubstring {

    public static void main(String[] args) {


        String str = "acbbaca";
        String pattern = "aba";

        System.out.println("min window: "+minWindow(str,pattern));
    }

    public static String minWindow(String s, String t) {
        if(t.length()>s.length()) {
            return "";
        }
        int matchedCount =0;
        int windowStart=0;
        String output ="";
        int minLength=Integer.MAX_VALUE;
        int subStrStart = 0;
        HashMap<Character,Integer> patternCharMap = new HashMap<>();
        HashMap<Character,Integer> charFreqMap = new HashMap<>();

        for(int i=0;i<t.length();i++) {
            Character pChar = t.charAt(i);
            patternCharMap.put(pChar,patternCharMap.getOrDefault(pChar,0)+1);
        }

        for(int windowEnd=0;windowEnd<s.length();windowEnd++) {
            Character rightChar = s.charAt(windowEnd);
            charFreqMap.put(rightChar,charFreqMap.getOrDefault(rightChar,0)+1);

            if(patternCharMap.containsKey(rightChar) && patternCharMap.get(rightChar)>=charFreqMap.get(rightChar)) {
                matchedCount=matchedCount+1;
            }


            System.out.println("matchedCount: "+matchedCount+" windowStart="+windowStart+" windowEnd="+windowEnd);

            while(matchedCount==t.length()) {
                Character leftChar = s.charAt(windowStart);
                charFreqMap.put(leftChar,charFreqMap.get(leftChar)-1);

                if(charFreqMap.get(leftChar)>=0 && patternCharMap.containsKey(leftChar) && charFreqMap.get(leftChar)<patternCharMap.get(leftChar) ) {
                    matchedCount--;
                }

                if(minLength>windowEnd-windowStart+1) {
                    minLength = windowEnd-windowStart+1;
                    subStrStart=windowStart;
                }

                windowStart++;

            }
        }

        System.out.println("minLength="+minLength+" subStrStart="+subStrStart);

        if(subStrStart+minLength>s.length()) {
            output="";
        } else{
            output = s.substring(subStrStart,subStrStart+minLength);
        }


        return output;
    }
}
