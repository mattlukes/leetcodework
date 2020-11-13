/*
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The
binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be
set to NULL.

Initially, all next pointers are set to NULL.

November 13, 2020
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        else if (root.right == null) {
            root.next = null;
            return root;
        }

        // We are guaranteed a perfect binary tree, so all null checks will only be to one descendant
        ArrayDeque<Node> queue = new ArrayDeque<>();
        root.next = null;
        queue.add(root.right);
        queue.add(root.left);
        int level = 1;
        int nodesToProcess = 2;

        Node rightNode = null;
        Node leftNode;

        while (!queue.isEmpty()) {
            if (rightNode == null) {
                rightNode = queue.remove();
                rightNode.next = null;
                if (rightNode.right != null) {
                    queue.add(rightNode.right);
                    queue.add(rightNode.left);
                }

                nodesToProcess--;
                continue;
            }

            leftNode = queue.remove();
            leftNode.next = rightNode;
            if (leftNode.right != null) {
                queue.add(leftNode.right);
                queue.add(leftNode.left);
            }
            rightNode = leftNode;
            nodesToProcess--;

            if (nodesToProcess <= 0) {
                level++;
                nodesToProcess = (int)Math.pow(2, level);
                rightNode = null;
            }
        }

        return root;
    }
}