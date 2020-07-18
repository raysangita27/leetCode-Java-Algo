/*
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
 

Example 2:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
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
    public boolean findTarget(TreeNode root, int k) {
        if(root == null )
            return false;
        ArrayList<Integer> result = new ArrayList<Integer>();
        inOrderList(root, result);
        int i = 0;
        int j = result.size()-1;
        while(i < j)
        {
            if(result.get(i) + result.get(j) == k)
                return true;
            else if(result.get(i) + result.get(j) < k)
                i++;
            else
                j--;
        }
        return false;
    }
    void inOrderList(TreeNode root,  ArrayList<Integer> result)
    {
        if(root == null)
            return ;
        inOrderList(root.left, result);
        result.add(root.val);
        inOrderList(root.right, result);
    }
}
