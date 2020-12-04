/*
Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the
root of the tree, and every node has no left child and only one right child.

December 3, 2020
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
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        else if (root.left == null
              && root.right == null) {
            return root;
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode node;
        List<Integer> valList = new ArrayList<>();

        while (!stack.isEmpty()) {
            node = stack.pop();
            valList.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        Collections.sort(valList);

        TreeNode result = new TreeNode(valList.get(0));
        TreeNode prevNode = result;

        for (int i = 1; i < valList.size(); i++) {
            TreeNode nextNode = new TreeNode(valList.get(i));
            prevNode.right = nextNode;
            prevNode = nextNode;
        }

        return result;
    }
}