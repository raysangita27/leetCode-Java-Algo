/*
Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.  (The values of the nodes may still be duplicates.)

Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.

The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

The right-most node is also defined by the same way with left and right exchanged.

Example 1

Input:
  1
   \
    2
   / \
  3   4

Ouput:
[1, 3, 4, 2]

Explanation:
The root doesn't have left subtree, so the root itself is left boundary.
The leaves are node 3 and 4.
The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
So order them in anti-clockwise without duplicates and we have [1,3,4,2].
 

Example 2

Input:
    ____1_____
   /          \
  2            3
 / \          / 
4   5        6   
   / \      / \
  7   8    9  10  
       
Ouput:
[1,2,4,7,8,9,10,6,3]

Explanation:
The left boundary are node 1,2,4. (4 is the left-most node according to definition)
The leaves are node 4,7,8,9,10.
The right boundary are node 1,3,6,10. (10 is the right-most node).
So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
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
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null)
            return result;
        result.add(root.val);
        findLeftBoundary(root.left);
        findLeaf(root.left);
        findLeaf(root.right);
        findRightBoundary(root.right);
        return result;
    }
    void findLeftBoundary(TreeNode root)
    {
        if(root == null)
            return;
        if(root.left != null)
        {
            result.add(root.val);
            findLeftBoundary(root.left);
        }
        else if(root.right != null)
        {
            result.add(root.val);
            findLeftBoundary(root.right);
        }
            
    }
    void findRightBoundary(TreeNode root)
    {
        if(root == null)
            return;
        if(root.right != null)
        {
            findRightBoundary(root.right);
            result.add(root.val);
        }
        else if( root.left != null)
        {
            findRightBoundary(root.left);
            result.add(root.val);
        }
            
    }
    void findLeaf(TreeNode root)
    {
        if(root == null)
            return ;
        if(root.left == null && root.right == null)
            result.add(root.val);
        findLeaf(root.left);
        findLeaf(root.right);
    }
}

/* Iterative approach */

class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> b = new ArrayList<Integer>();
        if(root==null)
            return b;
        TreeNode leftNode = root;
        b.add(leftNode.val);
        if(root.left!=null){
            while(leftNode.left!=null || leftNode.right!=null){
                if(leftNode.left!=null)
                    leftNode=leftNode.left;
                else if(leftNode.right!=null)
                    leftNode=leftNode.right;
                if(leftNode.left!=null || leftNode.right!=null)
                    b.add(leftNode.val);
            }
        }
        Stack<TreeNode> q = new Stack<TreeNode>();
        q.push(root);
        List<Integer> temp1 = new ArrayList<Integer>();
        while(!q.isEmpty()){
            TreeNode t = q.pop();
            if(t!=root && (t.left==null && t.right==null))
                temp1.add(t.val);
            if(t.left!=null)
                q.push(t.left);
            if(t.right!=null)
                q.push(t.right);
        }
        for(int i=temp1.size()-1;i>=0;i--){
            b.add(temp1.get(i));
        }
        
        List<Integer> temp = new ArrayList<Integer>();
        if(root.right==null)
            return b;
        TreeNode rightNode = root;
        while(rightNode.right!=null || rightNode.left!=null){
            if(rightNode.right!=null)
                rightNode=rightNode.right;
            else
                rightNode=rightNode.left;
            if(rightNode.left!=null || rightNode.right!=null)
                temp.add(rightNode.val);
        }
        
        for(int i=temp.size()-1;i>=0;i--){
            b.add(temp.get(i));
        }
        
        return b;
    }
}
