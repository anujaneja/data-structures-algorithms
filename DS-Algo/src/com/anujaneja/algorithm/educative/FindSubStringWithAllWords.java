package com.anujaneja.algorithm.educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class FindSubStringWithAllWords {

    public static List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> wordFreqMap = new HashMap<>();

        for(String word:words) {
            wordFreqMap.put(word,wordFreqMap.getOrDefault(word,0)+1);
        }

        ArrayList<Integer> resultIndices = new ArrayList<>();
        int wordsCount=words.length;
        int wordLength = words[0].length();

        int windowStart=0;

        for(int windowEnd=0;windowEnd<s.length();windowEnd++) {

            if(windowEnd-windowStart+1==wordsCount*wordLength) {
                HashMap<String,Integer> wordsSeen = new HashMap<>();
                String windowStr= s.substring(windowStart,windowEnd+1);

                for(int j=0;j<wordsCount;j++) {
                    int nextWordIndex =windowStart+ j*wordLength;
                    String nextWord = s.substring(nextWordIndex,nextWordIndex+wordLength);
//                    System.out.println(nextWord);
                    if(!wordFreqMap.containsKey(nextWord)) {
                        break;
                    }

                    wordsSeen.put(nextWord,wordsSeen.getOrDefault(nextWord,0)+1);
                }

                //checking if all words found...

                if(wordsSeen.size()==wordFreqMap.size()) {
                    //deep check for frequency
                    boolean allMatched=true;
                    for(Map.Entry<String,Integer> entry:wordFreqMap.entrySet() ) {

                        if(!entry.getValue().equals(wordsSeen.get(entry.getKey()))) {
                            allMatched=false;
                        }
                    }

                    if(allMatched) {
                        resultIndices.add(windowStart);
                    }

                }

                windowStart++;
            }

        }

        return resultIndices;
    }

    public static void main(String[] args) {
        String str = "barfoothefoobarman";
        String words[] = new String[]{"bar","foo"};

        System.out.println("words indexs: "+ Arrays.asList(findSubstring(str,words)));
    }
}
