/*
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode current = temp;
        while(current.next != null)
        {
            if(current.next.val == val)
            {
               ListNode next = current.next;
                current.next = next.next;
            }
            else
             current = current.next;
        }
        return temp.next;
    }
}
