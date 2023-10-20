/*
Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.

 

Example 1:


Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 8
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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result= new ArrayList<>();
        if(n == 0)
            return result;
        return generateSubTree(1, n);
    }
    public List<TreeNode> generateSubTree(int s, int e)
    {
        List<TreeNode> result= new ArrayList<>();
        if( s > e)
        {
            result.add(null);
            return result;
        }

        for(int i = s; i <= e; ++i)
        {
            List<TreeNode> leftSub = generateSubTree(s, i-1);
            List<TreeNode> rightSub = generateSubTree(i+1, e);
            for(TreeNode left : leftSub)
            {
                for(TreeNode right : rightSub)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }

        }
        return result;
    }
}
