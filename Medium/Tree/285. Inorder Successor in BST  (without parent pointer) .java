/*
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

The successor of a node p is the node with the smallest key greater than p.val.

 

Example 1:


Input: root = [2,1,3], p = 1
Output: 2
Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.
Example 2:


Input: root = [5,3,6,2,4,null,null,1], p = 6
Output: null
Explanation: There is no in-order successor of the current node, so the answer is null.
 

Note:

If the given node has no in-order successor in the tree, return null.
It's guaranteed that the values of the tree are unique.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null)
            return null;
        if(p.right != null)
            return findMinElement(p.right);
        TreeNode current = root;
        TreeNode succ = null;
        while(current != null)
        {
            if(p.val < current.val)
            {
                succ = current;
                current = current.left;
            }
            else if(p.val > current.val)
                current = current.right;
            else
                break;
        }
        return succ;
    }
    public TreeNode findMinElement(TreeNode node)
    {
        TreeNode current = node;
        while(current.left != null)
            current = current.left;
        return current;
        
    }
}
