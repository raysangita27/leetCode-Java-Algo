/*
Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.

You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.

 

![Example1](https://github.com/raysangita27/leetCode-Java-Algo/blob/master/images/bstdlloriginalbst.png)



Input: root = [4,2,5,1,3]


Output: [1,2,3,4,5]

![Explanation](https://github.com/raysangita27/leetCode-Java-Algo/blob/master/images/bstdllreturndll.png)
The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.

Example 2:

Input: root = [2,1,3]
Output: [1,2,3]
Example 3:

Input: root = []
Output: []
Explanation: Input is an empty tree. Output is also an empty Linked List.
Example 4:

Input: root = [1]
Output: [1]
 

Constraints:

-1000 <= Node.val <= 1000
Node.left.val < Node.val < Node.right.val
All values of Node.val are unique.
0 <= Number of Nodes <= 2000

*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null)      
            return null;
        Node left = treeToDoublyList(root.left);
        Node right = treeToDoublyList(root.right);
        root.left = root.right = root;
        return merge(merge(left, root), right );
    }
    Node merge(Node leftList, Node rightList)
    {
        if(leftList == null)
            return rightList;
        if(rightList == null)
            return leftList;
        
        Node leftLast = leftList.left;
        Node rightLast = rightList.left;
        
        leftLast.right = rightList;
        rightList.left = leftLast;
        
        rightLast.right = leftList;
        leftList.left = rightLast;
        
        return leftList;

    }
}

/*
Step 1: Divide:
We divide tree into three parts: left subtree, root node, right subtree.
Convert left subtree into a circular doubly linked list as well as the right subtree.
Be careful. You have to make the root node become a circular doubly linked list.

Step 2: Conquer:
Firstly, connect left circular doubly linked list with the root circular doubly linked list.
Secondly, connect them with the right circular doubly linked list. 
*/

/*
Time Complexity: O(N). Scanning the entire tree once
