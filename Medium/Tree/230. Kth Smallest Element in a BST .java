/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

 

Constraints:

The number of elements of the BST is between 1 to 10^4.
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;
        ArrayList<Integer> list = new ArrayList<>();
        createInOrderList(root, list);

            return list.get(k-1);
    }
    void createInOrderList(TreeNode root, ArrayList<Integer> list)
    {
        if(root == null)
            return ;
         createInOrderList(root.left, list);
         list.add(root.val);
         createInOrderList(root.right, list);
    }
}

/***************************** Iterative solution ************************************/

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return -1;

        Stack<TreeNode> stk = new Stack<>();
        while(root != null || !stk.isEmpty())
        {
            while(root != null)
            {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            if(--k == 0)
                return root.val;
            root = root.right;
        }    
        return -1;
    }
}
