/*
Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Example 2:


Input: root = [3,9,8,4,0,1,7]
Output: [[4],[9],[3,0,1],[8],[7]]
Example 3:


Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
Output: [[4],[9,5],[3,0,1],[8,2],[7]]
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        int min = 0;
        int max = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        
        q.add(new Pair<>(root, 0));
        while(!q.isEmpty())
        {
            var item = q.poll();
            TreeNode node = item.getKey();
            int col = item.getValue();
            if(!map.containsKey(col))
                map.put(col, new ArrayList<Integer>());
            map.get(col).add(node.val);
            
            if(node.left != null)
            {
                q.add(new Pair<>(node.left, col-1));
                min = Math.min(min, col-1);
            }
            if(node.right != null)
            {
                
                q.add(new Pair<>(node.right, col+1));
                max = Math.max(max, col+1);
            }
        }
        for(int i = min; i <= max; i++)
            result.add(map.get(i));
        return result;
        
    }
}
/*
The following solution takes 5ms.

BFS, put node, col into queue at the same time
Every left child access col - 1 while right child col + 1
This maps node into different col buckets
Get col boundary min and max on the fly
Retrieve result from cols
Note that TreeMap version takes 9ms.

*/
