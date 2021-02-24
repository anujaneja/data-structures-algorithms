package com.anujaneja.algorithm.educative.dfs;

import com.anujaneja.algorithm.tree.TreeNode;

/**
 * Easy - https://www.geeksforgeeks.org/check-root-leaf-path-given-sequence/
 */
public class PathWithGivenSequence {

    public static boolean findPath(TreeNode root, int[] sequence) {
        if (root == null) {
            return sequence.length == 0;
        }

        return findPath(root, sequence, 0);
    }

    public static boolean findPath(TreeNode root, int[] sequence, int sequenceIndex) {

        //leaf node true
        if (root.val == sequence[sequenceIndex] && root.left == null && root.right == null) {
            return true;
        }

        if (root.val != sequence[sequenceIndex]) {
            return false;
        }

        boolean leftSequencePathMatch = false;
        boolean rightSequencePathMatch = false;
        if (root.left != null) {
            leftSequencePathMatch = findPath(root.left, sequence, sequenceIndex + 1);
        }

        if (root.right != null) {
            rightSequencePathMatch = findPath(root.right, sequence, sequenceIndex + 1);
        }

        return leftSequencePathMatch || rightSequencePathMatch;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}
