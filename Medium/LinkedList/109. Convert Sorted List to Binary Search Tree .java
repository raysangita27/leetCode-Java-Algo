/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        int nodeCount = findNodeCount(head);
        return createBST(head, nodeCount);
        
    }
    TreeNode createBST(ListNode head, int nodeCount)
    {
        if(head == null || nodeCount <= 0)
            return null;
        TreeNode left = createBST(head, nodeCount/2);
        ListNode position = findTreeNodePosition(head,nodeCount/2);
        TreeNode root= null;
       if(position != null)
           root = new TreeNode(position.val);
        root.left = left;
        root.right = createBST(position.next,nodeCount- nodeCount/2-1);
        return root;
           
    }
    ListNode findTreeNodePosition(ListNode head, int count)
    {
        if(head == null || count == 0 )
            return head;
        int i = 0;
        ListNode current = head;
        while(current != null && i< count)
        {
            current = current.next;
            i++;
        }
        return current;
    }
    int findNodeCount(ListNode head)
    {
        if(head == null)
            return 0;
        ListNode current = head;
        int count = 0;
        while(current != null)
        {
            current = current.next;
            count++;
        }
        return count;
    }
}
