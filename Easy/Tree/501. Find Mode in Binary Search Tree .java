/*
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 

For example:
Given BST [1,null,2,2],

   1
    \
     2
    /
   2
 

return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
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
    public int[] findMode(TreeNode root) {
        if(root == null)
            return new int[]{};
        HashMap<Integer, Integer> map = new HashMap<>();
        inOrderNodes(root, map);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<>(){
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
            {
                return o2.getValue() - o1.getValue();
            }
        });
        //int[] result = new int[list.size()];
        List<Integer> temp = new ArrayList<>();
        int k = 0;
        int max = 0;
        for(var a : list)
        {
            
            if(a.getValue() >= max)
            {
                max = a.getValue();
                
               temp.add(a.getKey());
            }
        }
        int[] result = new int[temp.size()];
        for(int val : temp)
            result[k++] = val;
        return result;
        
        
    }
    void inOrderNodes(TreeNode root, HashMap<Integer, Integer> map )
    {
        if(root == null)
            return ;
        inOrderNodes(root.left, map);
            if(map.containsKey(root.val))
                map.put(root.val, map.get(root.val)+1);
            else
                map.put(root.val, 1);
        inOrderNodes(root.right, map);
    }
}
