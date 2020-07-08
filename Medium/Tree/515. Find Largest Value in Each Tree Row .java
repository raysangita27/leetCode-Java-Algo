/*
You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]
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
    public List<Integer> largestValues(TreeNode root) {
         List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty() )
        {
            int size = q.size();
            int maxNode = Integer.MIN_VALUE;
            while(size > 0)
            {
                TreeNode temp = q.remove();
                maxNode = Math.max(temp.val, maxNode);
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
                size --;
            }
            result.add(maxNode);
        }
        return result;
    }
}
