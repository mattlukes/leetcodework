/*
Sort a linked list using insertion sort.

November 2, 2020
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        else if (head.next == null) {
            return head;
        }

        ListNode unsortedListHead;
        ListNode sortedListHead = head;
        ListNode nodeToSort;

        unsortedListHead = head.next;
        sortedListHead.next = null;

        while (unsortedListHead != null) {
            ListNode sortedListLastNode = null;
            ListNode sortedListCompareNode = sortedListHead;
            nodeToSort = unsortedListHead;
            unsortedListHead = unsortedListHead.next;
            boolean nodeInserted = false;

            while (sortedListCompareNode != null) {
                if (nodeToSort.val < sortedListCompareNode.val) {
                    if (sortedListLastNode == null) {
                        nodeToSort.next = sortedListCompareNode;
                        sortedListHead = nodeToSort;
                    }
                    else {
                        sortedListLastNode.next = nodeToSort;
                        nodeToSort.next = sortedListCompareNode;
                    }

                    nodeInserted = true;
                    break;
                }
                else {
                    sortedListLastNode = sortedListCompareNode;
                    sortedListCompareNode = sortedListCompareNode.next;
                }
            }

            if (!nodeInserted) {
                sortedListLastNode.next = nodeToSort;
                nodeToSort.next = null;
            }
        }

        return sortedListHead;
    }
}