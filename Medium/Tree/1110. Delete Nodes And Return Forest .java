/*
Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.

 

Example 1:



Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
 

Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000.
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
    List<TreeNode> result;
    Set<Integer> set;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        result = new ArrayList<TreeNode>();
        set = new HashSet<Integer>();
        for(int i : to_delete)
            set.add(i);
        generateForest(root, null);
        return result;
    }
    public TreeNode generateForest(TreeNode root, TreeNode parent)
    {
        if(root == null)
            return null;
        TreeNode deletedNode = set.contains(root.val) ? null : root;
        if(deletedNode != null && parent == null)
            result.add(root);
        root.left = generateForest(root.left , deletedNode);
        root.right = generateForest(root.right , deletedNode);
        return deletedNode;
    }
}
