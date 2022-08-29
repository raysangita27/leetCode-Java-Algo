/*
Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.

 

Example 1:


Input: root = [4,2,5,1,3], target = 3.714286
Output: 4
Example 2:

Input: root = [1], target = 4.428571
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 109
-109 <= target <= 109
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
    public int closestValue(TreeNode root, double target) {
    if(root == null)
        return -1;
    int closest =  root.val;
    while(root != null)
    {
        if(Math.abs(root.val - target) < Math.abs(closest - target))
        {
            closest = root.val;
        }
        if(target < root.val)
        {
            root = root.left;
        }
        else
            root = root.right;
    }
    return closest;
}
}
