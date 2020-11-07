/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first
and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

November 7, 2020
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
import java.math.BigInteger;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuffer l1Buffer = new StringBuffer();
        StringBuffer l2Buffer = new StringBuffer();

        ListNode node = l1;

        while (node != null) {
            l1Buffer.append(node.val);
            node = node.next;
        }

        node = l2;

        while (node != null) {
            l2Buffer.append(node.val);
            node = node.next;
        }

        BigInteger l1AsNum = new BigInteger(l1Buffer.toString());
        BigInteger l2AsNum = new BigInteger(l2Buffer.toString());

        BigInteger sum = l1AsNum.add(l2AsNum);
        String sumAsString = String.valueOf(sum);
        ListNode sumHead = new ListNode(Integer.parseInt(String.valueOf(sumAsString.charAt(0))));
        node = sumHead;

        for (int i = 1; i < sumAsString.length(); i++) {
            ListNode newNode = new ListNode(Integer.parseInt(String.valueOf(sumAsString.charAt(i))));
            node.next = newNode;
            node = newNode;
        }

        return sumHead;
    }
}