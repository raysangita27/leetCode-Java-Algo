/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Stack<List<Integer>> stk = new Stack<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> tempList = new ArrayList<>();
            while(size > 0)
            {
                TreeNode temp = q.remove();
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
                tempList.add(temp.val);
                size--;
            }
            stk.push(tempList);
        }
        while(!stk.isEmpty() )
        {
            result.add(stk.pop() );
        }
        return result;
    }
}
