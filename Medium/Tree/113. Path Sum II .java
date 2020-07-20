/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
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
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
            return result;
        findSumofPath(root, sum , new ArrayList<Integer>());  
        return result;
    }
    
    public void findSumofPath(TreeNode root, int sum, ArrayList<Integer> l ){
        if(root == null)
            return;
        l.add(root.val);
        sum = sum - root.val;
        if(root.left == null && root.right == null && sum == 0)
            result.add(new ArrayList<>(l));
        if(root.left != null)
            findSumofPath(root.left, sum, l);
        if(root.right != null)
            findSumofPath(root.right, sum, l);
        l.remove(l.size()-1);
    }
}
