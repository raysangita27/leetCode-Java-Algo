/*
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0 || head.next == null)
            return head;
        int nodeCount = countNodeList(head);
        if(k == nodeCount)
            return head;
        if(nodeCount < k)
            k = k % nodeCount;
     
        int diff = nodeCount-k;
        if(nodeCount == diff || diff == 0)
            return head;
        ListNode current = head;
        int i = 0;
        while(i < diff-1)
        {
            current = current.next;
            i++;
        }
        ListNode newHead = current.next ;
        current.next = null;
        current = newHead;
        while(current.next != null)
        {
            current = current.next;
        }
        current.next = head;
        head = newHead;
        return head;
    }
    int countNodeList(ListNode head){
        if(head == null)
            return 0;
        ListNode current = head;
        int count = 0; 
        while(current!= null)
        {
            current = current.next;
            count++;
        }
        return count;
    }
}
