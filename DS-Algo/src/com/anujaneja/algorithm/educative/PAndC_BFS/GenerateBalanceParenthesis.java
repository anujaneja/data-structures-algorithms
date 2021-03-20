package com.anujaneja.algorithm.educative.PAndC_BFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Video Explaination - https://www.youtube.com/watch?v=eyCj_u3PoJE
 * Medium - https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateBalanceParenthesis {

    public static List<String> generateParenthesis(int n) {
        int O = n;
        int C = n;
        List<String> result = new ArrayList<>();
        String str = "";
        generateParenthesisRec(O, C, str, result);

        return result;
    }

    public static void generateParenthesisRec(int O, int C, String str, List<String> result) {
        //Base case
        if (O == 0 && C == 0) {
            result.add(str);
            return;
        }

        //'C' handling option 1
        if (O > 0) {
            generateParenthesisRec(O - 1, C, str + "(", result);
        }

        // ')' only if C > O counts...
        if (C > O) {
            generateParenthesisRec(O, C - 1, str + ")", result);
        }
    }

    public static void main(String[] args) {
        List<String> result = GenerateBalanceParenthesis.generateParenthesis(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateBalanceParenthesis.generateParenthesis(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
