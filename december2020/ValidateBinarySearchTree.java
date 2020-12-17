/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1

December 16, 2020
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
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }

        return validateSubTree(root, null, null);
    }

    private static boolean validateSubTree(TreeNode node, Integer floor, Integer ceiling) {
        boolean result = true;
        if (node.left != null) {
            if (node.left.val < node.val
             && (floor == null || node.left.val > floor)) {
                result = validateSubTree(node.left, floor, node.val);
            }
            else {
                result = false;
            }
        }

        if (!result) {
            return result;
        }

        if (node.right != null) {
            if (node.right.val > node.val
             && (ceiling == null || node.right.val < ceiling)) {
                result = validateSubTree(node.right, node.val, ceiling);
            }
            else {
                result = false;
            }
        }

        return result;
    }
}