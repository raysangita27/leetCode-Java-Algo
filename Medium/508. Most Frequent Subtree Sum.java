/*
Given the root of a binary tree, return the most frequent subtree sum. If there is a tie, return all the values with the highest frequency in any order.

The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).

 

Example 1:


Input: root = [5,2,-3]
Output: [2,-3,4]
Example 2:


Input: root = [5,2,-5]
Output: [2]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
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
    HashMap<Integer, Integer> map;
    int maxfreq = 1;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null)
            return new int[]{};
        map = new HashMap<>();
        postorder(root);
        ArrayList<Integer> result = new ArrayList<>();
        for(int key : map.keySet())
        {
            if(map.get(key) == maxfreq)
                result.add(key);
        }
        int arr[] = new int[result.size()];
        int i = 0;
       for(int n : result)
           arr[i++] = n;
        return arr;
    }
    public int postorder(TreeNode root)
    {
        if(root == null)
            return 0;
        int lSum = postorder(root.left);
        int rSum = postorder(root.right);
        int total = lSum + rSum + root.val;
        if(map.containsKey(total))
        {
            int count = map.get(total)+1;
            maxfreq= Math.max(maxfreq, count);
            map.put(total, count);
        }
        else
        {
            map.put(total, 1);
        }
        return total;
    }
}
