/*
Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.

 

Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:

Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]
Example 3:

Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]
Example 4:

Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]
Example 5:


Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]
 

Constraints:

Each tree has at most 5000 nodes.
Each node's value is between [-10^5, 10^5].
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<Integer>();
        if(root1 == null && root2 == null)
            return result;
        List<Integer> list1 =  new ArrayList<Integer>();
        inOrderList(root1, list1);
         List<Integer> list2 =  new ArrayList<Integer>();
        inOrderList(root2, list2);
        System.out.println(list1);
        System.out.println(list2);
        return mergeList(list1, list2);
    }
    List<Integer> mergeList(List<Integer> list1 , List<Integer> list2){
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list2;
        int i = 0; 
        int j = 0;
        //int k = 0;
        List<Integer> result = new ArrayList<Integer>();
        while(i< list1.size() && j < list2.size())
        {
            if(list1.get(i) <= list2.get(j) )
            {
                result.add(list1.get(i));
                i++;
            }
            else
            {
                result.add(list2.get(j));
                j++;
            }
        }
        while(i < list1.size() )
        {
            result.add(list1.get(i));
            i++;
        }
        while(j < list2.size() )
        {
            result.add(list2.get(j));
            j++;
        }
        return result;
    }
   
    void inOrderList(TreeNode root, List<Integer> list)
    {
        if(root == null)
            return ;
        inOrderList(root.left, list);
        list.add(root.val);
        inOrderList(root.right, list);
    }
}
