/*
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2:
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.
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
    public int findBottomLeftValue(TreeNode root) {
        if(root == null)
            return -1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int leftNode = -1;
        q.add(root);
        while(!q.isEmpty() )
        {
            int size = q.size();
            if(size > 0)
            {
                leftNode = q.peek().val;
                while(size > 0)
                {
                    TreeNode temp = q.remove();
                    if(temp.left != null)
                        q.add(temp.left);
                    if(temp.right != null)
                        q.add(temp.right);
                    size--;
                }
            }
        }
        return leftNode;
    }
}
