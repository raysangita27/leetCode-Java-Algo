/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode middleNode = findMiddle(head);
        ListNode rev = reverseNode(middleNode);
        
        while(head != middleNode && rev != null )
        {
            if(head.val != rev.val)
                return false;
            else
            {
                head = head.next;
                rev = rev.next;
            }
        }
        return true;
    }
    ListNode reverseNode(ListNode head)
    {
        if(head == null)
            return null;
        ListNode current = head;
        ListNode prev = head;
        while(current != null)
        {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    ListNode findMiddle(ListNode head){
        if(head == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
