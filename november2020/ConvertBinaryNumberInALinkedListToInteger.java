/*
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or
1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

November 1, 2020
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
    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        else if (head.next == null) {
            return head.val;
        }

        ListNode node = head;
        int result = 0;

        while (node != null) {
            if (node.val == 1) {
                if (result == 0) {
                    result = 1;
                }
                else {
                    result = result << 1;
                    result++;
                }
            }
            else {
                result = result << 1;
            }

            node = node.next;
        }

        return result;
    }
}