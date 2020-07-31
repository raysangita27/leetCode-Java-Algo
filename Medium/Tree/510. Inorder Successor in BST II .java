/*
Given a node in a binary search tree, find the in-order successor of that node in the BST.

If that node has no in-order successor, return null.

The successor of a node is the node with the smallest key greater than node.val.

You will have direct access to the node but not to the root of the tree. Each node will have a reference to its parent node. Below is the definition for Node:

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
 

Follow up:

Could you solve it without looking up any of the node's values?
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        if(node == null)
            return null;
        if(node.right != null)
            return findMinElement(node.right);
        Node p = node.parent;
        while(p != null && p.right == node)
        {
            node = p ;
            p = p.parent;
        }
        return p;
    }
    public Node findMinElement(Node node){
        Node root = node;
        while(root.left != null)
            root = root.left;
        return root;
    }
}
