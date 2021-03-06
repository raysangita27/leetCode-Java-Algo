/*
Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode result = null;
        if(l1.val <= l2.val)
        {
            result = l1;
            result.next = mergeTwoLists(l1.next, l2);
        }
        else
        {
            result = l2;
            result.next = mergeTwoLists(l1, l2.next);
        }
        return result;
    }
}
// TimeComplexity - O(n);
//n = Max(length of l1, length of l2)
// SpaceComplexity - O(n) 
