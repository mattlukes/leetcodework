/*
Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability
of being chosen.

December 2, 2020
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

    private int linkedListLength;
    private ListNode head;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        this.linkedListLength = 0;
        ListNode node = head;

        while (node != null) {
            this.linkedListLength++;
            node = node.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        Random random = new Random();
        int chosenNode = random.nextInt(linkedListLength);
        ListNode node = head;

        while (chosenNode > 0) {
            node = node.next;
            chosenNode--;
        }

        return node.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */