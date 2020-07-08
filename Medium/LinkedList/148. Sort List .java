/*
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode middle = findMiddle(head);
        ListNode middleNext = middle.next;
        middle.next = null;
        ListNode A = sortList(head);
        ListNode B = sortList(middleNext);
        
        return merge(A, B);
        
    }
    ListNode merge(ListNode A, ListNode B)
    {
        if(A == null)
            return B;
        if(B == null)
            return A;
        ListNode result = null;
        if(A.val <= B.val)
        {
            result = A;
            result.next = merge(A.next, B);
        }
        else if( A.val > B.val)
        {
            result = B;
            result.next = merge(A, B.next);
        }
        return result;
    }
    ListNode findMiddle(ListNode head){
        if(head == null)
            return null;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
