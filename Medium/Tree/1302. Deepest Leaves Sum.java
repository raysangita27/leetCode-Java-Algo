/*
Given the root of a binary tree, return the sum of values of its deepest leaves.
 

Example 1:


Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
Example 2:

Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 100
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
    public int deepestLeavesSum(TreeNode root) {
        if(root == null ) 
            return 0;
        int deepestSum = 0;
        int curLevel = 0;
        int depLev = 0;
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root,0));
        while(!q.isEmpty())
        {
            var cur = q.poll();
            TreeNode node = cur.getKey();
            curLevel = cur.getValue();
            if(node.left == null && node.right == null)
            {
                if(depLev < curLevel)
                {
                    depLev = curLevel;
                    deepestSum = node.val;
                }
                else if(depLev == curLevel)
                    deepestSum += node.val;
            }
            if(node.left != null)
                    q.add(new Pair<>(node.left, curLevel + 1));
            if(node.right != null)
                    q.add(new Pair<>(node.right, curLevel + 1));
            
        }
        return deepestSum;
    }
}

// Timecomplexity O(n) n => number of nodes
// Space complexity O(n) n => number of nodes
