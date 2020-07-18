/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Return the linked list sorted as well.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode current = temp;
        while(current.next != null && current.next.next != null)
        {
            if(current.next.val == current.next.next.val)
            {
                int duplicate = current.next.val;
                while(current.next != null && current.next.val == duplicate)
                    current.next = current.next.next;
              
            }
            else
                 current = current.next; 
        }
        return temp.next;
    }
}
