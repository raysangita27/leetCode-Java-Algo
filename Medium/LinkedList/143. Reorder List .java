/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
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
    public void reorderList(ListNode head) {
        if(head == null)
            return ;
        ListNode middle = getMiddleNode(head);
        ListNode secondHead = middle.next;
        middle.next = null;
        secondHead = reverse(secondHead);
        ListNode res= new ListNode(0);
        ListNode cur = res;
        ListNode first = head;
        ListNode temp = null;
        while(secondHead != null)
        {
            temp = first.next;
            first.next = secondHead;
            first = temp;
            temp = secondHead.next;
            secondHead.next = first;
            secondHead = temp;
        }
    }
   
    ListNode reverse(ListNode head)
    {
        if(head == null)
            return null;
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null)
        {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    ListNode getMiddleNode(ListNode current)
    {
        if(current == null)
            return null;
        ListNode fast = current;
        ListNode slow = current;
        while(fast != null && fast.next != null && slow != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
