/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

 

Example:



BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
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
class BSTIterator {
    TreeNode root ;
    ArrayList<Integer> list ;
    int itr = 0;
    public BSTIterator(TreeNode root) {
        this.root = root;
        list = new ArrayList<Integer>();
        createInOrderList(root,list);
    }
    
    /** @return the next smallest number */
    public int next() {
        int val = -1;
        if(itr< list.size())
        {
            val = list.get(itr);
            itr++;
        }
        return val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(itr < list.size() )
            return true;
        return false;
    }
    
    public void createInOrderList(TreeNode root, ArrayList<Integer> list)
    {
        if(root == null)
            return ;
        createInOrderList(root.left, list);
        list.add(root.val);
        createInOrderList(root.right, list);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
