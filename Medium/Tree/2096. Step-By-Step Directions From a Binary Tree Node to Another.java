/*
You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. You are also given an integer startValue representing the value of the start node s, and a different integer destValue representing the value of the destination node t.

Find the shortest path starting from node s and ending at node t. Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific direction:

'L' means to go from a node to its left child node.
'R' means to go from a node to its right child node.
'U' means to go from a node to its parent node.
Return the step-by-step directions of the shortest path from node s to node t.

 

Example 1:


Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
Output: "UURL"
Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.
Example 2:


Input: root = [2,1], startValue = 2, destValue = 1
Output: "L"
Explanation: The shortest path is: 2 → 1.
 

Constraints:

The number of nodes in the tree is n.
2 <= n <= 105
1 <= Node.val <= n
All the values in the tree are unique.
1 <= startValue, destValue <= n
startValue != destValue
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
    List<String> paths;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        if(root == null)
            return "";
        paths = new ArrayList<>();
        TreeNode lca = findLCA(root, startValue, destValue);
        StringBuilder startLCA = new StringBuilder();
        StringBuilder destLCA = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        generateStr(lca, startValue, startLCA);
        generateStr(lca, destValue, destLCA);
        
        for(int i = 0; i < paths.get(0).length(); i++)
        {
            sb.append("U");
        }
        return sb.append(paths.get(1)).toString();
    }
    public void generateStr(TreeNode lca, int key, StringBuilder ans)
    {
        if(lca == null)
            return;
        if(lca.val == key){
            paths.add(ans.toString());
            return;
        }
        if(lca.left != null){
            ans.append("L");
            generateStr(lca.left, key, ans);
        }
        
        if(lca.right != null){
            ans.append("R");
            generateStr(lca.right, key, ans);
        }
        ans.deleteCharAt(ans.length()-1);
        return;
        
    }
    
    public TreeNode findLCA(TreeNode root, int start, int dest)
    {
        if(root == null)
            return null;
        if(root.val == start || root.val == dest)
            return root;
        TreeNode l = findLCA(root.left, start, dest);
        TreeNode r = findLCA(root.right, start, dest);
        if(l != null && r != null)
            return root;
        return l == null ? r : l;
    }
}
