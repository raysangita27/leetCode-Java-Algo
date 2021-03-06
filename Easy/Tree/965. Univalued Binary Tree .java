/*
A binary tree is univalued if every node in the tree has the same value.

Return true if and only if the given tree is univalued.

 

Example 1:


Input: [1,1,1,1,1,null,1]
Output: true
Example 2:


Input: [2,2,2,5,2]
Output: false
 

Note:

The number of nodes in the given tree will be in the range [1, 100].
Each node's value will be an integer in the range [0, 99].
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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null) )
            return true;
        boolean left = true ;
        boolean right = true;
        if(root.left != null){
            if(root.val != root.left.val) 
                return false;
            else
                left = isUnivalTree(root.left);
        }
        if(root.right != null)
        {
            if(root.val != root.right.val)
                return false;
            else
                 right = isUnivalTree(root.right);
        }    
        if(left && right)
            return true;
        else
            return false;
        
    }
}
