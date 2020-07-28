/*
Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

 

Example:

Input: [1,2,3,4,5]
  
          1
         / \
        2   3
       / \     
      4   5    

Output: [[4,5,3],[2],[1]]
 

Explanation:

1. Removing the leaves [4,5,3] would result in this tree:

          1
         / 
        2          
 

2. Now removing the leaf [2] would result in this tree:

          1          
 

3. Now removing the leaf [1] would result in the empty tree:

          []         
[[3,5,4],[2],[1]], [[3,4,5],[2],[1]], etc, are also consider correct answers since per each level it doesn't matter the order on which elements are returned.

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
    public List<List<Integer>> findLeaves(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)
            return result;
        setLeaves(root);
        return result;
    }
    int setLeaves(TreeNode root)
    {
        if(root == null)
            return 0;
        int leftHeight = setLeaves(root.left);
        int rightHeight = setLeaves(root.right);
        int max  = Math.max(leftHeight, rightHeight);
        if(result.size()-1< max)
        {
            result.add(new ArrayList<Integer>());
        }
        var list = result.get(max);
        list.add(root.val);
        return max+1;
    }
}
