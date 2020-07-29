/*
Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

Example :

Input: [1,2,3]
Output: [1,2,4]
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
    public ListNode plusOne(ListNode head) {
        if(head == null) 
            return null;
        head = reverse(head);
        int carry = 1;
        ListNode current = head;
        ListNode result = null;
        while(current != null)
        {
            int sum = (current != null ? current.val : 0) + carry;
            ListNode temp = new ListNode(sum %10);
            if(result == null)
                result = temp;
            else
            {
                temp.next = result;
                result = temp;
            }
            carry = sum /10;
            current =  current.next;
            
        }
        if(carry > 0){
            ListNode temp = new ListNode(carry);
            temp.next = result;
            result = temp;   
        }
        
        return result;
    }
    ListNode reverse(ListNode head)
    {
        if(head == null)
            return null;
        ListNode current = head;
        ListNode prev = null;
        while(current != null)
        {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
