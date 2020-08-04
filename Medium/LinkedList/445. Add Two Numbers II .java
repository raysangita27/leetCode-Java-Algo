/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        int s1 = findLength(l1);
        int s2 = findLength(l2);
        System.out.println("s1 length " + s1 +  " s2 length " + s2);
        ListNode resHead = null;
        ListNode n = null;
        
        while(l1 != null || l2!= null)
        {
            int val1 = 0;
            int val2 = 0;
            if(s1 >= s2)
            {
                val1 = (l1 != null) ?  l1.val : 0 ;
                l1 = l1.next;
                s1 --;
            }
            if(s2 >= s1+1)
            {
                val2 = (l2 != null) ?  l2.val : 0;
                l2 = l2.next;
                s2 --;
            }
            n = new ListNode(val1 + val2);
            n.next = resHead;
            resHead = n;
            
        }
        resHead = null;
        int carry = 0;
        while(n != null)
        {
            n.val = n.val + carry;
            System.out.println(n.val);
            if(n.val >= 10)
            {
                n.val = n.val % 10;
                carry = 1;
            }
            else
                carry = 0;
            ListNode nextNode = n.next;
            n.next = resHead;
            resHead = n;
            n = nextNode;
        }
        if (carry > 0) {
        n = new ListNode(1);
        n.next = resHead;
        resHead = n;
    }
        return resHead;
        
    }
    int findLength(ListNode root)
    {
        if(root == null)
            return 0;
        return findLength(root.next) +1;
    }
}
