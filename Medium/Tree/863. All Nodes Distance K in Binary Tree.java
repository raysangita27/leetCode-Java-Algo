/*
Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
Example 2:

Input: root = [1], target = 1, k = 3
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 500].
0 <= Node.val <= 500
All the values Node.val are unique.
target is the value of one of the nodes in the tree.
0 <= k <= 1000
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode, TreeNode> map;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        map = new HashMap<>();
        dfs(root, null);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(null);
        q.add(target);
        visited.add(target);
        visited.add(null);
        int count = 0;
        while(!q.isEmpty())
        {
            TreeNode cur =q.poll();
            if(cur == null)
            {
                if(count == k)
                {
                    List<Integer> ans = new ArrayList<>();
                    for(var n : q)
                        ans.add(n.val);
                    return ans;
                }
                count++;
                q.add(null);
            }
            else
            {
                if(!visited.contains(cur.left))
                {
                    visited.add(cur.left);
                    q.add(cur.left);
                }
                if(!visited.contains(cur.right))
                {
                    visited.add(cur.right);
                    q.add(cur.right);
                }
                if(!visited.contains(map.get(cur)))
                {
                    visited.add(map.get(cur));
                    q.add(map.get(cur));
                }
            }
        }
        return result;
    }
    public void dfs(TreeNode root,TreeNode par)
    {
        if(root != null){
        map.put(root, par);

            dfs(root.left, root);

            dfs(root.right, root);
        }
    }
}
