/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        Stack<TreeNode> stk1 = new Stack<>();
        Stack<TreeNode> stk2 = new Stack<>();
        stk1.push(root);
        while(!stk1.isEmpty() || !stk2.isEmpty() )
        {
            int size = stk1.size();
            if(size > 0){
                List<Integer> temp = new ArrayList<Integer>();
                while(size > 0)
                {

                    TreeNode current = stk1.pop();
                    if(current.left!=null)
                        stk2.push(current.left);
                    if(current.right != null)
                        stk2.push(current.right);
                    temp.add(current.val);
                    size--;
                }
                if(temp != null)
                    result.add(temp);    
            }
            int size2 = stk2.size();
            if(size2 > 0){
                List<Integer> temp1 = new ArrayList<Integer>();
                while(size2 > 0)
                {

                    TreeNode current = stk2.pop();
                    if(current.right != null)
                        stk1.push(current.right);
                    if(current.left!=null)
                        stk1.push(current.left);
                    temp1.add(current.val);
                    size2 --;
                }
                if(temp1 != null)
                    result.add(temp1);
            }
           
        }
        return result;
    }
}
