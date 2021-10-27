package com.anujaneja.algorithm.tree.BST;
import com.anujaneja.algorithm.tree.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;

public class BSTKthLargest {
    public static TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }

        if (key < root.val) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }

        return root;
    }

    //Reverse in-order Tree Traversal...
    public static int kthLargestBST(TreeNode root, AtomicInteger i, int k) {
        if (root == null) {
            return 0;
        }

        int result = kthLargestBST(root.right, i, k);

        if (result > 0) {
            return result;
        }

        i.incrementAndGet();

        if (i.get() == k) {
            return root.val;
        }

        return kthLargestBST(root.left, i, k);
    }

    public static int kthLargestBST(TreeNode root, int k) {
        AtomicInteger i = new AtomicInteger(0);
        return kthLargestBST(root, i, k);
    }

    public static void main(String[] args) {
        TreeNode root = null;
        int[] keys = { 13, 14, 22, 25, 23, 32, 26, 28, 40 };

        for (int key : keys) {
            root = insert(root, key);
        }

        int k = 7;
        int res = kthLargestBST(root, k);

        if (res != Integer.MAX_VALUE) {
            System.out.print(res);
        } else {
            System.out.print("Invalid Input");
        }
    }
}

/* Try more Inputs

case1:
keys = [13, 14, 22, 25, 23, 32, 26,28,40]
root = insert(root, key)
actual = findKthLargest(root,3)
expected = 22

case2:
keys = [5,3,6,2,4,1]
root = insert(root, key)
actual = findKthLargest(root,3)
expected = 3

*/

