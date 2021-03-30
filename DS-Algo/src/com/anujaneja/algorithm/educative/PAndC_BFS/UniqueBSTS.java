package com.anujaneja.algorithm.educative.PAndC_BFS;

import com.anujaneja.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Video Explaination - https://www.youtube.com/watch?v=SHp-uB4ngkU
 * Medium - https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBSTS {
    public static List<TreeNode> findUniqueTrees(int n) {
        List<TreeNode> result = new ArrayList<>();

        if(n<=0) {
            return result;
        }
        return genTreeRec(1,n);
    }

    public static List<TreeNode> genTreeRec(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        if(start>end) {
            result.add(null);
            return result;
        }

        for(int i=start;i<=end;i++) {
            List<TreeNode> leftTreeNodes = genTreeRec(start,i-1);
            List<TreeNode> rightTreeNodes = genTreeRec(i+1,end);

            for(TreeNode leftNode:leftTreeNodes) {
                for(TreeNode rightNode:rightTreeNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }

        return  result;
    }

    public static void main(String[] args) {
        List<TreeNode> result = UniqueBSTS.findUniqueTrees(3);
        System.out.print("Total trees: " + result.size());
    }
}
