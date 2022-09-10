/*
Given the root of a binary tree, return the maximum average value of a subtree of that tree. Answers within 10-5 of the actual answer will be accepted.

A subtree of a tree is any node of that tree plus all its descendants.

The average value of a tree is the sum of its values, divided by the number of nodes.

 

Example 1:


Input: root = [5,6,1]
Output: 6.00000
Explanation: 
For the node with value = 5 we have an average of (5 + 6 + 1) / 3 = 4.
For the node with value = 6 we have an average of 6 / 1 = 6.
For the node with value = 1 we have an average of 1 / 1 = 1.
So the answer is 6 which is the maximum.
Example 2:

Input: root = [0,null,1]
Output: 1.00000
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 105
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
    double max = 0;
    public double maximumAverageSubtree(TreeNode root) {
        if(root == null)
            return max;
        preorder(root);
        return max ;
    }
    public double[] preorder(TreeNode root)
    {
        if(root == null)
            return new double[]{0,0};
        double[] lVal = preorder(root.left);
        double[] rVal = preorder(root.right);
        double node = lVal[1] + rVal[1]+1;
        double sum = lVal[0] + rVal[0] + root.val;
        max = Math.max(max, (sum/ node));
        return new double[]{sum, node};
    }
}
