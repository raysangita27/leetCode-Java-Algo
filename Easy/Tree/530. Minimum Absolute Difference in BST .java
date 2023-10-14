/*
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 

Note:

There are at least two nodes in this BST.
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
    public int getMinimumDifference(TreeNode root) {
        if(root == null)
            return 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        inOrderList(root, list);
        int diff= Integer.MAX_VALUE;
        for(int i = 0; i< list.size()-1; i++)
        {
            if(Math.abs(list.get(i) - list.get(i+1) ) < diff )
                diff = Math.abs(list.get(i) - list.get(i+1) );        
        }
        return diff;
    }
    public void inOrderList(TreeNode root, ArrayList<Integer> list )
    {
        if(root == null)
            return ;
        inOrderList(root.left, list);
        list.add(root.val);
        inOrderList(root.right, list);
    }
}

/************************ recursive*******************/
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
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        if(root == null)
            return -1;
        inorder(root);
        return minDiff;
    }
    public void inorder(TreeNode root)
    {
        if(root == null)
            return;
        inorder(root.left);
        if(prev != null)
            minDiff = Math.min(minDiff, Math.abs( prev.val - root.val));
        prev = root;
        inorder(root.right);

    }
}
