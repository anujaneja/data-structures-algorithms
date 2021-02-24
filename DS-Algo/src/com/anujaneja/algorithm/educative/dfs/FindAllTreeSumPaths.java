package com.anujaneja.algorithm.educative.dfs;

import com.anujaneja.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium - https://leetcode.com/problems/path-sum-ii/
 *
 */
public class FindAllTreeSumPaths {

    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        findPathsRec(root, sum, currPath, allPaths);
        return allPaths;
    }

    public static void findPathsRec(TreeNode root, int targetSum, List<Integer> currPath, List<List<Integer>> allPaths) {
        if (root == null) {
            return;
        }

        //leaf node...
        if (root.val == targetSum && root.left == null && root.right == null) {
            currPath.add(root.val);
            //Copy current path...
            allPaths.add(new ArrayList<>(currPath));
        } else {
            int updatedSum = targetSum - root.val;
            currPath.add(root.val);
            findPathsRec(root.left, updatedSum, currPath, allPaths);
            findPathsRec(root.right, updatedSum, currPath, allPaths);
        }

        //remove last node from current path because...we have back tracked from this node....
        //i.e. removing last element....
        currPath.remove(currPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreeSumPaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
