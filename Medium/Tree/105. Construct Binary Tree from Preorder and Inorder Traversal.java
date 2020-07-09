/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
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
    int preIndex = 0; 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0  )
            return null;
        if(preorder.length == 1 )
            return new TreeNode(preorder[0]);
        return buildBTUtil(preorder, inorder, 0, preorder.length-1);
    }
    
    int findInOrderIndex(int[] inorder, int left, int right, int key)
    {
        
        for(int i = left; i<= right; i++)
        {
            if(inorder[i] == key)
                return i;
        }
        return -1;
    }
    
    TreeNode buildBTUtil(int[] preorder, int[] inorder, int left, int right)
    {
        if(left > right)
            return null;
        // if(preIndex > preorder.length-1)
        //     return null;
        TreeNode temp = new TreeNode(preorder[preIndex++]);
        if(preIndex < preorder.length){
            
        if(left == right)
            return temp;
        int inIndex = findInOrderIndex(inorder, left, right, temp.val);
        temp.left = buildBTUtil(preorder, inorder, left, inIndex-1);
        temp.right = buildBTUtil(preorder, inorder, inIndex+1, right);
        }
        return temp;
        
    }
}
