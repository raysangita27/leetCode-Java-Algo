/*
Given the root of a binary tree, return all duplicate subtrees.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with the same node values.

 

Example 1:


Input: root = [1,2,3,4,null,2,4,null,null,4]
Output: [[2,4],[4]]
Example 2:


Input: root = [2,1,1]
Output: [[1]]
Example 3:


Input: root = [2,2,2,3,null,3,null]
Output: [[2,3],[3]]
 

Constraints:

The number of the nodes in the tree will be in the range [1, 10^4]
-200 <= Node.val <= 200
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
    List<TreeNode>  result ;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)
            return result;
        preorder(root, new HashMap<String, Integer>());
        return result;
        
    }
    public String preorder(TreeNode root, HashMap<String, Integer> map)
    {
        if(root == null)
            return "#";
        String ans = Integer.toString(root.val) + "," + preorder(root.left, map) + "," + preorder(root.right, map);
        if(!map.containsKey(ans))
            map.put(ans, 1);
        else
            map.put(ans, map.get(ans) +1 );
        if(map.get(ans) == 2)
            result.add(root);
        return ans;    
    }
}

/*
The above time complexity is O(n^2). We can improve this to O(n) by replacing full serializations with serial ids instead.
*/
