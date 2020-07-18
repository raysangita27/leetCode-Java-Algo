/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 0 || k ==1)
            return head;
        int nodeCount = countNode(head);
        if(nodeCount < k  )
            return head;
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        int i = 0;
        while( i< k && current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }
        if(next != null)
            head.next = reverseKGroup(next, k);
        return prev;
    }
     int countNode(ListNode head)
    {
        if(head == null)
            return 0;
        ListNode current = head;
        int count = 1;
        while(current.next != null)
        {
            current = current.next;
            count++;
        }
        return count;
    }
}
