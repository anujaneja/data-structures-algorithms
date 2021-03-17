package com.anujaneja.algorithm.educative.PAndC_BFS;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutations {

    public static List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        result.add(S);

        if (S.length() < 1) {
            return result;
        }

        for (int i = 0; i < S.length(); i++) {

            if (Character.isLetter(S.charAt(i))) {
                int currLen = result.size();

                for (int j = 0; j < currLen; j++) {
                    char[] chars = result.get(j).toCharArray();
                    if (Character.isUpperCase(chars[i])) {
                        chars[i] = Character.toLowerCase(chars[i]);
                    } else {
                        chars[i] = Character.toUpperCase(chars[i]);
                    }
                    result.add(String.valueOf(chars));

                }
            }

        }

        return result;
    }

    public static List<String> letterCasePermutationWithRec(String S) {
        List<String> result = new ArrayList<>();
        result.add(S);
        letterCasePermutationRec(S, 0, result);
        return result;
    }

    public static void letterCasePermutationRec(String S, int index, List<String> result) {
        if (index >= S.length()) {
            return;
        }

        if (Character.isLetter(S.charAt(index))) {
            int currLen = result.size();

            for (int j = 0; j < currLen; j++) {
                char[] chars = result.get(j).toCharArray();
                if (Character.isUpperCase(chars[index])) {
                    chars[index] = Character.toLowerCase(chars[index]);
                } else {
                    chars[index] = Character.toUpperCase(chars[index]);
                }
                result.add(String.valueOf(chars));
            }

            letterCasePermutationRec(S, index + 1, result);
        } else {
            letterCasePermutationRec(S, index + 1, result);
        }
    }

    public static void main(String[] args) {
        List<String> result = LetterCasePermutations.letterCasePermutation("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCasePermutations.letterCasePermutation("ab7c");
        System.out.println(" String permutations are: " + result);

        System.out.println("...Recursion permutations...");

        result = LetterCasePermutations.letterCasePermutationWithRec("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCasePermutations.letterCasePermutationWithRec("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
