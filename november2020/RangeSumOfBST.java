/*
Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range
[low, high].

November 15, 2020
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int result = 0;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.val >= low
             && node.val <= high) {
                result += node.val;
            }

            if (node.left != null
             && node.val >= low) {
                stack.push(node.left);
            }

            if (node.right != null
             && node.val <= high) {
                stack.push(node.right);
            }
        }

        return result;
    }
}