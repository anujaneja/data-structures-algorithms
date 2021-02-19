package com.anujaneja.algorithm.educative.bfs;

import com.anujaneja.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * Easy - https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class ReverseLevelOrderTraversal {

    public static List<List<Integer>> traverse(TreeNode root) {
        if(root==null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while (!queue.isEmpty()) {
            //queue size is levelSize...
            int levelSize = queue.size();
            //1. level wise dequeue
            //2. add its left and right childs...
            List<Integer> currentLevel = new ArrayList<>();

            for(int i=0;i<levelSize;i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if(node.left!=null) {
                    queue.add(node.left);
                }

                if(node.right!=null) {
                    queue.add(node.right);
                }
            }

            result.add(0,currentLevel);
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
        List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);

    }
}
