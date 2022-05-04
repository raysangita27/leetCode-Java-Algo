/*
Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.

The length of the path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [5,4,5,1,1,5]
Output: 2
Example 2:


Input: root = [1,4,5,4,4,5]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
The depth of the tree will not exceed 1000.*/

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
    int ans;
public int longestUnivaluePath(TreeNode root) {
	if(root == null)
		return 0;
	ans = 0;
	findPathLength(root);
	return ans;
    }

public int findPathLength(TreeNode root)
{
	if(root == null )
		return 0;
	int left = findPathLength(root.left);
	int right = findPathLength(root.right);
	int lLength = 0;
	int rLength = 0;
	if(root.left != null && root.left.val == root.val)
		lLength = left+1;
	if(root.right != null && root.right.val == root.val)
		rLength = right +1 ;
	ans = Math.max(ans, lLength + rLength);
	return Math.max(lLength, rLength);
}

}
/*
Complexity Analysis

Time Complexity: O(N)O(N), where NN is the number of nodes in the tree. We process every node once.

Space Complexity: O(H)O(H), where HH is the height of the tree. Our recursive call stack could be up to HH layers deep.
*.
