/*
Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while(!stk.isEmpty() )
        {
            TreeNode temp = stk.pop();
            result.add(temp.val);
            if(temp.right != null)
                stk.push(temp.right);
            if(temp.left != null)
                stk.push(temp.left);
        }
        return result;
    }
}
