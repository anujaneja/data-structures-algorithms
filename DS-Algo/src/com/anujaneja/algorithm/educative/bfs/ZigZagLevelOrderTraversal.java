package com.anujaneja.algorithm.educative.bfs;

import com.anujaneja.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Easy - https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1
 * Medium - https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class ZigZagLevelOrderTraversal {

    public static List<List<Integer>> traverse(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leftToRight = true;
        queue.offer(root);

        while (!queue.isEmpty()) {
            //queue size is levelSize...
            int levelSize = queue.size();

            //1. level wise dequeue
            //2. add its left and right childs...
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if(leftToRight) {
                    currentLevel.add(node.val);
                } else {
                    currentLevel.add(0,node.val);
                }


                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

            }

            leftToRight = !leftToRight;
            result.add(currentLevel);
        }

        return result;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = ZigZagLevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);

    }
}
