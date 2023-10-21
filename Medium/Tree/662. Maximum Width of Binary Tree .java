/*
Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:

Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:

Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:

Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:

Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) 
            return 0;
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxSize = -1;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            maxSize = Math.max(maxSize, size );
            while(size > 0)
            {
                TreeNode temp = q.remove();
                if(temp == null)
                {
                    q.add(null);
                    q.add(null);
                }
                else
                {
                    q.add(temp.left);
                    q.add(temp.right);
                }
                size--;
            }
            while(!q.isEmpty() && q.peekFirst() == null )
                q.removeFirst();
            while(!q.isEmpty() && q.peekLast() == null )
                q.removeLast();
        }
        return maxSize;
    }
    
}

/******************************using queue*******************************/

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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1)); 
        int maxWidth = 0;  
        while(!queue.isEmpty())
        {
            var head = queue.peek();
            int size = queue.size();
            Pair<TreeNode, Integer> current = null ;
            for(int i = 0; i < size; i++)
            {
                current = queue.remove();
                TreeNode curNode = current.getKey();
                int freq = current.getValue();
                if(curNode.left != null)
                {
                    queue.add(new Pair<>(curNode.left, 2*freq));
                }
                if(curNode.right != null)
                {
                    queue.add(new Pair<>(curNode.right, 2*freq + 1));
                }
            }
            maxWidth = Math.max(maxWidth, current.getValue() - head.getValue() +1);
        }
        return maxWidth;
    }
}
