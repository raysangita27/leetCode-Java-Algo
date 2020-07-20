/*
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3 
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
    List<String> result = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        result.clear();
        if(root == null)
            return result;
        String path = "" + root.val;
        generatePath(root,path );
        return result;
    }
    void generatePath(TreeNode root, String path)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            result.add(path);
        if(root.left != null)
        {
            
            generatePath(root.left, path + "->" + root.left.val);
            
        }
        if(root.right != null)
        {
            generatePath(root.right,  path + "->" + root.right.val);
            
        }
            
    }
}
