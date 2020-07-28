/*
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?


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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0)
            return head;
        int i = 0;
        ListNode current = head;
        while(current.next != null && i<n-1)
        {
            current = current.next;
            i++;
        }
        // if value of N greater than no of nodes in the list
        if(current == null)
            return head;
        //// if value of N is equal to no of nodes in the list
        if( current.next == null)
            return head.next;
        
        ListNode prev = null;
        ListNode target = head;
        while(current.next != null)
        {
            prev = target;
            target = target.next;
            current = current.next;
        }
       
        prev.next = target.next;
        return head;
    }
}
