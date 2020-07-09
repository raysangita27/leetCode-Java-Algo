/*
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000].
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return null;
        return createMaxTree(nums, 0, len-1);
    }
    int findMaxElementInd(int[] nums, int l, int r){
        int maxEle = Integer.MIN_VALUE;
        int maxInd = -1;
        for(int i = l; i<=r; i++)
        {
            if(nums[i]> maxEle)
            {
                maxEle = nums[i];
                maxInd = i;
            }
        }
        return maxInd;
    }
    TreeNode createMaxTree(int[] nums, int l, int r)
    {
        if( l > r)
            return null;
        int ind = findMaxElementInd(nums, l, r);
        TreeNode root = new TreeNode(nums[ind]);
        root.left = createMaxTree(nums, l, ind-1);
        root.right = createMaxTree(nums, ind+1, r);
        return root;
    }
}
