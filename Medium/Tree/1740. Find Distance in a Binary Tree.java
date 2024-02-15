/*
Given the root of a binary tree and two integers p and q, return the distance between the nodes of value p and value q in the tree.

The distance between two nodes is the number of edges on the path from one to the other.

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 0
Output: 3
Explanation: There are 3 edges between 5 and 0: 5-3-1-0.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 7
Output: 2
Explanation: There are 2 edges between 5 and 7: 5-2-7.
Example 3:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 5
Output: 0
Explanation: The distance between a node and itself is 0.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 109
All Node.val are unique.
p and q are values in the tree.

*/

private int find(TreeNode root, int val){
        if(root == null) return -1;
        if(root.val == val) return 0;

        int left = find(root.left,val);
        int right = left >= 0 ? -1:find(root.right,val);

        return left >= 0 ? left+1 : right >=0 ? right+1 : -1;
    }

    private TreeNode LCA(TreeNode root,int p, int q){
        if(root == null) return null;
        if(root.val == p || root.val == q) return root;
        TreeNode leftLCA = LCA(root.left,p,q);
        TreeNode rightLCA = LCA(root.right, p,q);

        if(leftLCA != null && rightLCA != null) return root;

        return leftLCA != null ? leftLCA : rightLCA;
    }

    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = LCA(root,p,q);
        int ld = find(lca,p);
        int rd = find(lca, q);
        return ld+rd;
    }

/*****************QueueBasedSolution********************/
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
    public int findDistance(TreeNode root, int p, int q) {
        if(root == null)
            return 0;
        TreeNode lca = findLCA(root, p, q);
        int pDist = findLength(lca, p);
        int qDist = findLength(lca, q);
        return pDist + qDist;
    }
    public int findLength(TreeNode root, int p)
    {
        if(root.val == p)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode cur = queue.remove();
                if(cur.val == p)
                    return level;
                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);
            }
            level++;
        }
        return level;
    }
    public TreeNode findLCA(TreeNode root, int p, int q)
    {
        if(root == null)
            return null;
        if(root.val == p || root.val == q)
            return root;
        TreeNode lVal = findLCA(root.left, p, q);
        TreeNode rVal = findLCA(root.right, p, q);
        if(lVal != null && rVal != null)
            return root;
        return lVal == null ? rVal : lVal;
    }
}
