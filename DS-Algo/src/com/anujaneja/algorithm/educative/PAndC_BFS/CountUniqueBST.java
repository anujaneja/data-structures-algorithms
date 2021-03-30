package com.anujaneja.algorithm.educative.PAndC_BFS;

import java.util.HashMap;
import java.util.Map;

/**
 * Medium - https://leetcode.com/problems/unique-binary-search-trees/
 * Explaination - http://www.zrzahid.com/number-of-unique-binary-search-trees/
 */
public class CountUniqueBST {

    public static void main(String[] args) {
        CountUniqueBST ct = new CountUniqueBST();
        int count = ct.countTrees(1);
        System.out.print("Total trees: " + count);
    }

    public int countTrees(int n) {
        if (n <= 1) {
            return 1;
        }

        Map<Integer, Integer> memoizedMap = new HashMap<>();
        return countTreeRec(n, memoizedMap);
    }

    public int countTreeRec(int n, Map<Integer, Integer> memoizedMap) {
        if(memoizedMap.containsKey(n)) {
            return memoizedMap.get(n);
        }

        if (n <= 1) {
            return 1;
        }

        int count = 0;

        for(int i=1;i<=n;i++) {
            int leftCount = countTreeRec( i-1, memoizedMap);
            int rightCount = countTreeRec( n-i, memoizedMap);
            count += leftCount * rightCount;
        }


        memoizedMap.put(n,count);

        return count;
    }
}
