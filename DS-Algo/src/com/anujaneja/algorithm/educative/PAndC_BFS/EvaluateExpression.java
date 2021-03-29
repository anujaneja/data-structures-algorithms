package com.anujaneja.algorithm.educative.PAndC_BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * find all possible outcomes of an expression...
 * Medium - https://www.geeksforgeeks.org/find-all-possible-outcomes-of-a-given-expression/
 */
public class EvaluateExpression {
    public static List<Integer> diffWaysToEvaluateExpression(String input) {
        HashMap<String,List<Integer>> memoziedMap = new HashMap<>();
        return diffWaysToEvaluateExpressionRec(input, 0,input.length()-1,memoziedMap);
    }

    public static int eval(int a, char op, int b)
    {
        if (op == '+')
        {
            return a + b;
        }
        if (op == '-')
        {
            return a - b;
        }
        if (op == '*')
        {
            return a * b;
        }
        return Integer.MAX_VALUE;
    }


    public static boolean isOperator(char ch) {
        return ch == '*' || ch == '-' || ch == '+' || ch == '/';
    }

    public static List<Integer> diffWaysToEvaluateExpressionRec(String input, int low,int high,Map<String,List<Integer>> memoziedMap) {
        if(memoziedMap.get(input)!=null) {
            return memoziedMap.get(input);
        }

        if (input == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        if (low==high) {
            result.add(input.charAt(low)-'0');
            return result;
        }

        if(low==(high-2)) {
            int num = eval(input.charAt(low)-'0',input.charAt(low+1),input.charAt(low+2)-'0');
            result.add(num);
            memoziedMap.getOrDefault(input,new ArrayList<>()).add(num);
            return result;
        }

        /*
            TO handle the case of "11" having number with multiple digits...
         */

        String inputSubStr= input.substring(low,high+1);

        if(!inputSubStr.contains("+") && !inputSubStr.contains("-") && !inputSubStr.contains("*")) {
            int num = Integer.parseInt(inputSubStr);
            result.add(num);
            memoziedMap.getOrDefault(input,new ArrayList<>()).add(num);
            return result;
        }

        for(int i=low+1;i<=high;i++) {
            if(isOperator(input.charAt(i))) {
                List<Integer> leftResults =  diffWaysToEvaluateExpressionRec(input,low,i-1,memoziedMap);
                List<Integer> rightResults = diffWaysToEvaluateExpressionRec(input,i+1,high,memoziedMap);

                for (Integer leftResult : leftResults) {
                    for (Integer rightResult : rightResults) {
                        int val = eval(leftResult, input.charAt(i), rightResult);
                        result.add(val);
                        memoziedMap.getOrDefault(input,new ArrayList<>()).add(val);

                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = EvaluateExpression.diffWaysToEvaluateExpression("1+2*3");
        System.out.println("Expression evaluations: " + result);

        result = EvaluateExpression.diffWaysToEvaluateExpression("2*3-4-5");
        System.out.println("Expression evaluations: " + result);
    }

}
