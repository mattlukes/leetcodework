/*
Given a linked list, rotate the list to the right by k places, where k is non-negative.

October 7, 2020
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0
         || head == null
         || head.next == null) {
            return head;
        }

        ListNode node = head;
        int listLength = 0;

        while (node != null) {
            listLength++;
            node = node.next;
        }

        if (k % listLength == 0) {
            return head;
        }

        int shiftLength = listLength - (k % listLength);

        ArrayDeque<ListNode> queue = new ArrayDeque<>();
        node = head;

        while (shiftLength > 0) {
            queue.add(node);
            node = node.next;
            shiftLength--;
        }

        ListNode newHead = node;
        while (!queue.isEmpty()) {
            if (node.next != null) {
                node = node.next;
            }
            else {
                ListNode nextNode = queue.remove();
                node.next = nextNode;
                nextNode.next = null;
            }
        }

        return newHead;
    }
}