/*
Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:



Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
Output: 20
Explanation: Maximum sum in a valid Binary search tree is obtained in root node with key equal to 3.
Example 2:



Input: root = [4,3,null,1,2]
Output: 2
Explanation: Maximum sum in a valid Binary search tree is obtained in a single root node with key equal to 2.
Example 3:

Input: root = [-4,-2,-5]
Output: 0
Explanation: All values are negatives. Return an empty BST.
 

Constraints:

The number of nodes in the tree is in the range [1, 4 * 104].
-4 * 104 <= Node.val <= 4 * 104
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
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        if(root == null)
            return 0;
        postorder(root);
        return maxSum;
    }
    public int[] postorder(TreeNode root)
    {
        if(root == null)
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int[] l = postorder(root.left);
        int[] r = postorder(root.right);
        if(!(l!= null && r != null && l[1] < root.val &&  root.val < r[0]))
        {
            return null;
        }
        int sum = l[2] + r[2] + root.val;
        maxSum = Math.max(maxSum, sum);
        int min = Math.min(l[0], root.val);
        int max = Math.max(r[1], root.val);
        return new int[]{min, max, sum};
    }
}
