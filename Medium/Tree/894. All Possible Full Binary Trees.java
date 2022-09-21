/*
Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.

Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.

A full binary tree is a binary tree where each node has exactly 0 or 2 children.

 

Example 1:


Input: n = 7
Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
Example 2:

Input: n = 3
Output: [[0,0,0]]
 

Constraints:

1 <= n <= 20

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
    
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> result = new ArrayList<>();
        if(n == 1)
        {
            result.add(new TreeNode(0));
            return result;
        }
        n = n-1;
        for(int i = 1; i < n; i+=2)
        {
            List<TreeNode> leftlist = allPossibleFBT(i);
            List<TreeNode> rightlist = allPossibleFBT(n-i);
            for(var iteml : leftlist)
            {
                for(var itemr : rightlist)
                {
                    TreeNode root = new TreeNode(0);
                    root.left = iteml;
                    root.right = itemr;
                    result.add(root);
                }
            }
        }
        return result;
    }
 
}
