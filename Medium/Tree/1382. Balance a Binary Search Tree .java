/*
Given a binary search tree, return a balanced binary search tree with the same node values.

A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.

If there is more than one answer, return any of them.

 

Example 1:



Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2,null,null] is also correct.
 

Constraints:

The number of nodes in the tree is between 1 and 10^4.
The tree nodes will have distinct values between 1 and 10^5.
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
    public TreeNode balanceBST(TreeNode root) {
        if(root == null)
            return root;
        ArrayList<Integer> inList = new ArrayList<Integer>();
        inOrderTraverse(root, inList);
        return createBST(inList, 0, inList.size()-1);
    }
    TreeNode createBST(ArrayList<Integer> inList, int left, int right)
    {
        if(left > right)
            return null;
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(inList.get(mid));
        if(left == right)
            return root;
        root.left = createBST(inList, left, mid-1);
        root.right = createBST(inList, mid+1, right);
        return root;
    }
    void inOrderTraverse(TreeNode root,  ArrayList<Integer> inList )
    {
        if(root == null)
            return;
        inOrderTraverse(root.left, inList);
        inList.add(root.val);
        inOrderTraverse(root.right, inList);
    }
}
