/*
Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.

 

Example 1:


Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
Example 2:


Input: root = [5,3,6,2,4,null,7], k = 28
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-104 <= Node.val <= 104
root is guaranteed to be a valid binary search tree.
-105 <= k <= 105
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
    List<Integer> list;
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) 
            return false;
        list = new ArrayList<>();
        inorder(root);
        int s = 0;
        int e = list.size()-1;
        while(s < e)
        {
            if(list.get(s) + list.get(e) == k)
                return true;
            else if(list.get(s) + list.get(e) < k)
                s++;
            else
                e--;
        }
        return false;
    }
    public void inorder(TreeNode root)
    {
        if(root == null)    
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
