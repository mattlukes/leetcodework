/*
Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic
if at least one permutation of the node values in the path is a palindrome.

Return the number of pseudo-palindromic paths going from the root node to leaf nodes.

Constraints:

The given binary tree will have between 1 and 10^5 nodes.
Node values are digits from 1 to 9.

December 29, 2020
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
    private static int[] valCount = new int[10];

    public static int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else if (root.right == null
              && root.left == null) {
            return 1;
        }

        return computeSubTree(root);
    }

    private static int computeSubTree(TreeNode node) {
        int result = 0;
        valCount[node.val]++;

        if (node.left == null
         && node.right == null) {
            if (analyzeCurrPath(valCount)) {
                result++;
            }
        }
        else {
            if (node.left != null) {
                result += computeSubTree(node.left);
            }

            if (node.right != null) {
                result += computeSubTree(node.right);
            }
        }

        valCount[node.val]--;

        return result;
    }

    private static boolean analyzeCurrPath(int[] valCount) {
        boolean palindromePermutation = true;
        boolean oddValCount = false;
        int totalValCount = 0;

        for (int i = 1; i < 10; i++) {
            totalValCount += valCount[i];

            if (valCount[i] % 2 == 1) {
                // The maximum amount of odd characters any palindrome can possibly have is 1
                if (oddValCount) {
                    palindromePermutation = false;
                    break;
                }
                else {
                    oddValCount = true;
                }
            }
        }

        // A character with an odd count works if and only if the string is of odd length
        if ((totalValCount % 2 == 1 && !oddValCount)
         || (totalValCount % 2 == 0 && oddValCount)) {
            palindromePermutation = false;
        }

        return palindromePermutation;
    }
}