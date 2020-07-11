/*
Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

Example :

Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \    
    1   3  

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
Note:

The size of the BST will be between 2 and 100.
The BST is always valid, each node's value is an integer, and each node's value is different.
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
    public int minDiffInBST(TreeNode root) {
        if(root == null)
            return 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        inOrderList(root, list);
        int distance = Integer.MAX_VALUE;
        for(int i = 0; i< list.size() - 1; i++)
        {
            distance = Math.min(distance,(list.get(i+1) - list.get(i) ) );
        }
        return distance;
    }
    public void inOrderList(TreeNode root, ArrayList<Integer> list)
    {
        if(root == null)
            return ;
        inOrderList(root.left, list);
        list.add(root.val);
        inOrderList(root.right, list);
        
    }
}
