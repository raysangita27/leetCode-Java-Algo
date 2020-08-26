/*
Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Consider the following binary search tree: 

     5
    / \
   2   6
  / \
 1   3
Example 1:

Input: [5,2,6,1,3]
Output: false
Example 2:

Input: [5,2,1,3,6]
Output: true
Follow up:
Could you do it using only constant space complexity?
*/
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length <= 1)
            return true;
        return validateBST(preorder, 0, preorder.length-1);
    }
    
    private boolean validateBST(int[] pre, int left, int right)
    {
        if(pre == null || right -left < 1)
            return true;
        int root = pre[left];
        int index = left+1;
        while(index <= right && pre[index] < root)
            index++;
        int tempInd = index;
        while(index <= right)
        {
            if(pre[index]< root)
                return false;
            index++;
        }
        boolean l = validateBST(pre, left+1, tempInd-1);
        boolean r = validateBST(pre, tempInd, right);
        
        return l && r;
    }
}
