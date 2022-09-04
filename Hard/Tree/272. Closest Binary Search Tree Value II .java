/*
Given the root of a binary search tree, a target value, and an integer k, return the k values in the BST that are closest to the target. You may return the answer in any order.

You are guaranteed to have only one unique set of k values in the BST that are closest to the target.

 

Example 1:


Input: root = [4,2,5,1,3], target = 3.714286, k = 2
Output: [4,3]
Example 2:

Input: root = [1], target = 0.000000, k = 1
Output: [1]
 

Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104.
0 <= Node.val <= 109
-109 <= target <= 109
 

Follow up: Assume that the BST is balanced. Could you solve it in less than O(n) runtime (where n = total nodes)?


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
        PriorityQueue<Integer> pQ = null;
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        pQ = new PriorityQueue<>(k,  (e1, e2) -> { return  Double.compare( Math.abs(e2-target),Math.abs(e1 - target)) ; });
        inorder(root, k);
        for(int item : pQ)
            result.add(item);
        return result;
    }

    public void inorder(TreeNode root, int k)
    {
        if(root == null)
            return;
        inorder(root.left, k);
        pQ.add(root.val);
        if(pQ.size() > k)
            pQ.remove();
        inorder(root.right, k);
    }
}
