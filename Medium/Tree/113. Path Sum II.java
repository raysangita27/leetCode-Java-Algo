/*
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
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
    List<List<Integer>> result;

public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    result = new ArrayList<List<Integer>>();
    if(root == null)
        return result;
    checkPath(root, targetSum, new ArrayList<Integer>());
    return result;
}

public void checkPath(TreeNode root, int target, ArrayList<Integer> ans)
{
    if(root == null)
        return ;
    target = target-root.val;
    ans.add(root.val);
    if(root.left == null && root.right == null)
    {
        if(target == 0)
        {
            result.add(new ArrayList<>(ans));
        }
    }
    checkPath(root.left, target, ans );
    checkPath(root.right, target, ans);
    ans.remove(ans.size()-1);
}
}
