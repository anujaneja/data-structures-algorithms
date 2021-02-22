package com.anujaneja.algorithm.educative.bfs;

import com.anujaneja.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Medium - https://www.geeksforgeeks.org/connect-nodes-level-level-order-traversal/
 * Medium - https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * Medium - https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * NOTE: CONSTANT SPACE need to do with/without Recursion...
 */
public class ConnectLevelOrderSiblings {

    public static void connectLevelOrderSiblings(TreeNode root) {
        //Null or leaf node then return....
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        //case 1: root left and right child are not null....
        if (root.left != null && root.right != null) {
            root.left.next = root.right;

            if (root.next != null) {
                root.right.next = findNextAvailableNode(root.next);
            }
            //case 2: root either left or right child is not null...
        } else if ((root.left == null || root.right == null) && root.next != null) {
            if (root.left != null) {
                root.left.next = findNextAvailableNode(root.next);
            } else if (root.right != null) {
                root.right.next = findNextAvailableNode(root.next);
            }
        }

        connectLevelOrderSiblings(root.right);
        connectLevelOrderSiblings(root.left);
    }

    private static TreeNode findNextAvailableNode(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.left != null) {
            return node.left;
        }

        if (node.right != null) {
            return node.right;
        }

        return findNextAvailableNode(node.next);
    }

    public static void printLevelOrderByNext(TreeNode root) {
        if (root == null) {
            return;
        }

        List<Set<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            //queue size is levelSize...
            int levelSize = queue.size();
            //1. level wise dequeue
            //2. add its left and right childs...
            Set<Integer> currentLevel = new LinkedHashSet<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                    queue.add(node.left.next);
                } else if (node.right != null) {
                    queue.add(node.right);
                    queue.add(node.right.next);
                }
            }

            result.add(currentLevel);
        }

        System.out.println("result: " + result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        ConnectLevelOrderSiblings.connectLevelOrderSiblings(root);
        printLevelOrderByNext(root);
    }

}
