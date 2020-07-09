/*
Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        while(true)
        {
            while(root!= null)
            {
                stk.push(root);
                stk.push(root);
                root = root.left;
            }
            if(stk.isEmpty() )
                break;
            root = stk.pop();
            if(!stk.isEmpty() && stk.peek() == root )
                root = root.right;
            else{
                result.add(root.val);
                root = null;
            }
                
        }
        return result;
    }
}
