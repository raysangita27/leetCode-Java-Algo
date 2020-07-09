/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
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
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return null;
        return createBST(nums, 0, len-1);
    }
    TreeNode createBST(int[] nums, int left, int right)
    {
        if(left > right)
            return null;
        int mid = (left + right)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        if(left == right)
            return root;
        root.left = createBST(nums, left, mid-1);
        root.right = createBST(nums, mid+1, right);
        return root;
    }
}
