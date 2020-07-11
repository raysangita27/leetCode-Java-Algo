/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
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
class PostInd{
    int index;
}
class Solution {
    PostInd postIndex = new PostInd();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0)
            return null;
        postIndex.index = postorder.length -1;
        return createBinaryTree(inorder, postorder, postIndex, 0,postorder.length-1, postorder.length );
    }
    
    int findInIndex(int[] inorder, int left, int right, int key){
        for(int i = left ; i<= right; i++)
        {
            if(key == inorder[i])
                return i;
        }
        return -1;
    }
    
    TreeNode createBinaryTree(int[] inorder, int[] postorder, PostInd postIndex, int left, int right, int n)
    {
        if(  postIndex.index  < 0 || left > right)
            return null;
        TreeNode root = new TreeNode(postorder[postIndex.index]);
        postIndex.index --;
        
        if(left == right)
            return root;
        int inInd = findInIndex(inorder, left, right, root.val);
        
        root.right = createBinaryTree(inorder, postorder, postIndex, inInd+1, right, n);
        root.left =   createBinaryTree(inorder, postorder, postIndex, left, inInd -1, n);
        return root;
        
    }
}
