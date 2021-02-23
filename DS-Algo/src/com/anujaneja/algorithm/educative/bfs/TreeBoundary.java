package com.anujaneja.algorithm.educative.bfs;

import com.anujaneja.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Video Explanation - https://www.youtube.com/watch?v=Csk6QEFyrtQ
 * Medium - https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 * Medium - https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1#
 * NOTE: Time Complexity: O(n), Space Complexity : O(1)
 */
public class TreeBoundary {

    public static void traverseLeftBoundary(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        //check for Non-leaf node...
        if (root.left != null || root.right != null) {
            result.add(root.val);
        }

        //Give preference to left-subtree...
        if (root.left != null) {
            traverseLeftBoundary(root.left, result);
        } else if (root.right != null) {
            traverseLeftBoundary(root.right, result);
        }
    }

    public static void traverseRightBoundary(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        //Give preference to right-subtree...
        if (root.right != null) {
            traverseRightBoundary(root.right, result);
        } else if (root.left != null) {
            traverseRightBoundary(root.left, result);
        }

        //check for Non-leaf node...
        if (root.left != null || root.right != null) {
            result.add(root.val);
        }
    }

    public static void traverseLeaves(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        traverseLeaves(root.left, result);

        if (root.left == null && root.right == null) {
            result.add(root.val);
        }

        traverseLeaves(root.right, result);
    }

    public static List<Integer> traverseTreeBoundary(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> result = new ArrayList<>();
        result.add(root.val);

        if (root.left == null && root.right == null) {
            return result;
        }

        traverseLeftBoundary(root.left, result);
        traverseLeaves(root, result);
        traverseRightBoundary(root.right, result);

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        List<Integer> result = TreeBoundary.traverseTreeBoundary(root);

        System.out.println("Boundary Traversal: " + result);
    }

}
