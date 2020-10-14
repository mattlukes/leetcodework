/*
Given the head of a linked list, return the list after sorting it in ascending order.

October 13, 2020
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
    public static ListNode sortList(ListNode head) {
        if (head == null
         || head.next == null) {
            return head;
        }

        List<Integer> valList = new ArrayList<>();
        ListNode node = head;

        while (node != null) {
            valList.add(node.val);
            node = node.next;
        }

        Collections.sort(valList);

        ListNode newHead = new ListNode(valList.get(0));
        node = newHead;

        for (int i = 1; i < valList.size(); i++) {
            node.next = new ListNode(valList.get(i));
            node = node.next;
        }

        return newHead;
    }
}