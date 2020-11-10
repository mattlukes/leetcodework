/*
Given the root of a binary tree, find the maximum value V for which there exist different nodes A and B where
V = |A.val - B.val| and A is an ancestor of B.

A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.

November 9, 2020
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        if (root == null
         || (root.right == null
          && root.left == null)) {
            return 0;
        }

        int leftSubTreeMaxDiff = 0;
        int rightSubTreeMaxDiff = 0;

        if (root.left != null) {
            int maxVal = Math.max(root.val, root.left.val);
            int minVal = Math.min(root.val, root.left.val);
            leftSubTreeMaxDiff = traverseSubTree(root.left, maxVal - minVal, minVal, maxVal);
        }

        if (root.right != null) {
            int maxVal = Math.max(root.val, root.right.val);
            int minVal = Math.min(root.val, root.right.val);
            rightSubTreeMaxDiff = traverseSubTree(root.right, maxVal - minVal, minVal, maxVal);
        }

        return Math.max(leftSubTreeMaxDiff, rightSubTreeMaxDiff);
    }

    private int traverseSubTree(TreeNode node, int maxDiff, int minVal, int maxval) {
        int newMaxDiff = maxDiff;
        if (node.left != null
                || node.right != null) {
            if (node.left != null) {
                int newMinVal = Math.min(minVal, node.left.val);
                int newMaxVal = Math.max(maxval, node.left.val);
                newMaxDiff = Math.max(newMaxDiff, newMaxVal - newMinVal);
                newMaxDiff = traverseSubTree(node.left, newMaxDiff, newMinVal, newMaxVal);
            }

            if (node.right != null) {
                int newMinVal = Math.min(minVal, node.right.val);
                int newMaxVal = Math.max(maxval, node.right.val);
                newMaxDiff = Math.max(newMaxDiff, newMaxVal - newMinVal);
                newMaxDiff = traverseSubTree(node.right, newMaxDiff, newMinVal, newMaxVal);
            }
        }

        return newMaxDiff;
    }
}