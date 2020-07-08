/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 )
            return null;
        int k = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(k, new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        } );
        
        for(int i = 0; i<k ; i++)
        {
            if(lists[i] != null)
                 pq.add(lists[i]);
        }
           
        ListNode result = new ListNode(0);
        ListNode current = result;
        while(!pq.isEmpty() )
        {
            ListNode temp = pq.remove();
            if(temp.next != null)
                pq.add(temp.next);
            temp.next = null;
            current.next = temp;
            current = current.next;
        }
        return result.next;
    }
}
