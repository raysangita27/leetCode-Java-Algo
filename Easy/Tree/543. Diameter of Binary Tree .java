/*
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)  
            return 0;
        int ld = diameterOfBinaryTree(root.left);
        int rd = diameterOfBinaryTree(root.right);
        int lheight = getHeight(root.left);
        int rheight = getHeight(root.right);
        
        return Math.max(lheight + rheight , Math.max(ld,rd));
    }
    
    int getHeight(TreeNode root)
    {
        if(root == null)
            return 0;
        return Math.max(getHeight(root.left),getHeight(root.right)) +1;
    }
}

/**************************improved********************************/

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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return diameter;
        findDiameter(root);
        return diameter;
    }
    private int findDiameter(TreeNode root)
    {
        if(root == null)
            return 0;
        int lD = findDiameter(root.left);
        int rD = findDiameter(root.right);
        diameter = Math.max(diameter, lD +rD);
        return Math.max(lD, rD)+1;
    }
}
