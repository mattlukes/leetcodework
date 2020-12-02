/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf
node.

December 1, 2020
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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else if (root.left == null
                && root.right == null) {
            return 1;
        }

        ArrayDeque<TreeNodeWithDepth> stack = new ArrayDeque<>();
        stack.push(new TreeNodeWithDepth(root, 1));

        int result = 0;

        while (!stack.isEmpty()) {
            TreeNodeWithDepth currNode = stack.pop();
            result = Math.max(result, currNode.depth);

            if (currNode.node.left != null) {
                stack.push(new TreeNodeWithDepth(currNode.node.left, currNode.depth + 1));
            }

            if (currNode.node.right != null) {
                stack.push(new TreeNodeWithDepth(currNode.node.right, currNode.depth + 1));
            }
        }

        return result;
    }

    public class TreeNodeWithDepth {
        TreeNode node;
        int depth;
        TreeNodeWithDepth(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}