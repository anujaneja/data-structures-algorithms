package com.anujaneja.algorithm.educative.two_pointer;

/**
 * Easy - https://leetcode.com/problems/backspace-string-compare/
 *
 */
public class CompareStringsContainsBackspaces {

    public static boolean backspaceCompare(String S, String T) {
        if ("".equals(S) && "".equals(T)) {
            return true;
        }

        int i = S.length() - 1;
        int j = T.length() - 1;

        while (i >= 0 || j >= 0) {
            int i1 = findNextValidCharIndex(S, i);
            int j1 = findNextValidCharIndex(T, j);

//            System.out.println("i1=" + i1 + " j1=" + j1);

            //End of both string reached...
            if (i1 < 0 && j1 < 0) {
                return true;
            }

            if (i1 < 0 || j1 < 0) {
                return false;
            }

            if (S.charAt(i1) != T.charAt(j1)) {
                return false;
            } else {
                i = i1 - 1;
                j = j1 - 1;
            }

        }

        return true;

    }

    public static int findNextValidCharIndex(String S, int index) {
        int backspaceCount = 0;

        while (index >= 0) {
            if (S.charAt(index) == '#') {
                backspaceCount++;
            } else if (backspaceCount > 0) {
                backspaceCount--;
            } else {
                break;
            }

            index--;
        }

        return index;
    }

    public static void main(String[] args) {
        String S = null;
        String T = null;
        boolean expected = false;

        //Test Case 1: Negative
        S="";
        T="";
        expected = true;

        System.out.println("Expected: "+expected+" Actual: "+backspaceCompare(S,T));

        //Test Case 2: Negative
        S="#";
        T="#";
        expected = true;

        System.out.println("Expected: "+expected+" Actual: "+backspaceCompare(S,T));

        //Test Case 3: Negative
        S="####";
        T="#";
        expected = true;

        System.out.println("Expected: "+expected+" Actual: "+backspaceCompare(S,T));


        //Test Case 4: Negative
        S="a####";
        T="b#";
        expected = true;

        System.out.println("Expected: "+expected+" Actual: "+backspaceCompare(S,T));


        //Test Case 5: Positive
        S="ab#c";
        T="ad#c";
        expected = true;

        System.out.println("Expected: "+expected+" Actual: "+backspaceCompare(S,T));


        //Test Case 6: Positive
        S="ab##";
        T="c#d#";
        expected = true;

        System.out.println("Expected: "+expected+" Actual: "+backspaceCompare(S,T));


        //Test Case 7: Positive
        S="a##c";
        T="#a#c";
        expected = true;

        System.out.println("Expected: "+expected+" Actual: "+backspaceCompare(S,T));


        //Test Case 8: Positive
        S="a#c";
        T="b";
        expected = false;

        System.out.println("Expected: "+expected+" Actual: "+backspaceCompare(S,T));


        //Test Case 9: Positive
        S="a####c";
        T="b####c";
        expected = true;

        System.out.println("Expected: "+expected+" Actual: "+backspaceCompare(S,T));

    }
}
