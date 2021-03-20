package com.anujaneja.algorithm.educative.PAndC_BFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Hard - https://www.geeksforgeeks.org/alphanumeric-abbreviations-of-a-string/
 */
public class UniqueGeneralizeAbbr {

    public static List<String> generalizeAbbr(String str) {
        List<String> result = new ArrayList<>();
        String op = "";
        generalizeAbbrRec(str, 0, op, result);

        return result;
    }

    public static void generalizeAbbrRec(String str, int index, String op, List<String> result) {
        //Base case...
        if (index == str.length()) {
            result.add(op);
            return;
        }

        //Abbrevate string...
        String S = op;
        char[] chs = S.toCharArray();

        //index >0 and letter...
        if ((index > 0 && Character.isLetter(S.charAt(S.length() - 1))) || index == 0) {
            S = S + "1";
        } else if (index > 0 && Character.isDigit(S.charAt(S.length() - 1))) {
            int a = (Character.getNumericValue(chs[S.length() - 1]) + 1);
            S= S.substring(0,S.length()-1)+a;
        }

        generalizeAbbrRec(str, index + 1, S, result);
        //Just add next chanacter...
        S = op + str.charAt(index);
        generalizeAbbrRec(str, index + 1, S, result);
    }

    public static void main(String[] args) {
        String input = "BAT";
        List<String> result = UniqueGeneralizeAbbr.generalizeAbbr(input);
        System.out.println("Result: " + result);


        input = "code";
        result = UniqueGeneralizeAbbr.generalizeAbbr(input);
        System.out.println("Result: " + result);
    }
}
