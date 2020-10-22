/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

October 22, 2020
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        ArrayDeque<TreeNodeWithDepth> stack = new ArrayDeque<>();
        stack.push(new TreeNodeWithDepth(root, 1));

        while (!stack.isEmpty()) {
            TreeNodeWithDepth nodeWithDepth = stack.pop();

            if (nodeWithDepth.depth >= result) {
                continue;
            }

            if (nodeWithDepth.treeNode.right == null
                    && nodeWithDepth.treeNode.left == null) {
                result = nodeWithDepth.depth;
            }
            else {
                if (nodeWithDepth.treeNode.left != null) {
                    stack.push(new TreeNodeWithDepth(nodeWithDepth.treeNode.left, nodeWithDepth.depth + 1));
                }

                if (nodeWithDepth.treeNode.right != null) {
                    stack.push(new TreeNodeWithDepth(nodeWithDepth.treeNode.right, nodeWithDepth.depth + 1));
                }
            }
        }

        return result;
    }

    public class TreeNodeWithDepth {
        TreeNode treeNode;
        int depth;

        TreeNodeWithDepth(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }
}