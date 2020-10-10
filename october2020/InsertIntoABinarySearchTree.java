/*
You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of
the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion.
You can return any of them.

October 6, 2020
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
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val, null, null);
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<>(1);
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (val < node.val) {
                if (node.left != null) {
                    stack.push(node.left);
                }
                else {
                    node.left = new TreeNode(val, null, null);
                    break;
                }
            }
            else {
                if (node.right != null) {
                    stack.push(node.right);
                }
                else {
                    node.right = new TreeNode(val, null, null);
                    break;
                }
            }
        }

        return root;
    }
}