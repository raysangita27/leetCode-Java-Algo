/*
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        //q.add(null);
        int sum = 0;
        while(!q.isEmpty() )
        {
            TreeNode temp = q.remove();
            if(temp.left != null)
            {
                q.add(temp.left);
                if(temp.left.left == null && temp.left.right == null)
                    sum +=temp.left.val;
            }
            if(temp.right != null)
                q.add(temp.right);
        }
        return sum;
    }
}
