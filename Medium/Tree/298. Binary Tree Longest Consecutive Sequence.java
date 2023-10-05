/*
Given the root of a binary tree, return the length of the longest consecutive sequence path.

A consecutive sequence path is a path where the values increase by one along the path.

Note that the path can start at any node in the tree, and you cannot go from a node to its parent in the path.

 

Example 1:


Input: root = [1,null,3,2,4,null,null,null,5]
Output: 3
Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
Example 2:


Input: root = [2,null,3,2,null,1]
Output: 2
Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
 

Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-3 * 104 <= Node.val <= 3 * 104

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
    int maxLength = 0;
   
    public int longestConsecutive(TreeNode root) {
        if(root == null)
            return 0;
        findPath(root, 0, null);
        return maxLength;   
    }
    public void findPath(TreeNode root, int count,  TreeNode prev )
    {
        if(root == null)
        {
            maxLength = Math.max(maxLength, count);
            return;
        }
        if(prev == null){
            count = 1;
            prev = root;
        }
        else if(root.val == prev.val +1)
        {
            count++;
        }
        else
        {
            maxLength = Math.max(maxLength, count);
            count = 1;

        }
        prev = root;
        findPath(root.left, count, prev);
        findPath(root.right, count, prev);
        
        
    }
}

/***********Time complexity O(n)*********************
