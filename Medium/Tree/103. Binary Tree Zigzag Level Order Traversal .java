/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        Stack<TreeNode> stk1 = new Stack<>();
        Stack<TreeNode> stk2 = new Stack<>();
        stk1.push(root);
        while(!stk1.isEmpty() || !stk2.isEmpty() )
        {
            int size = stk1.size();
            if(size > 0){
                List<Integer> temp = new ArrayList<Integer>();
                while(size > 0)
                {

                    TreeNode current = stk1.pop();
                    if(current.left!=null)
                        stk2.push(current.left);
                    if(current.right != null)
                        stk2.push(current.right);
                    temp.add(current.val);
                    size--;
                }
                if(temp != null)
                    result.add(temp);    
            }
            int size2 = stk2.size();
            if(size2 > 0){
                List<Integer> temp1 = new ArrayList<Integer>();
                while(size2 > 0)
                {

                    TreeNode current = stk2.pop();
                    if(current.right != null)
                        stk1.push(current.right);
                    if(current.left!=null)
                        stk1.push(current.left);
                    temp1.add(current.val);
                    size2 --;
                }
                if(temp1 != null)
                    result.add(temp1);
            }
           
        }
        return result;
    }
}

/****************using single queue ***********************/
 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
     List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (root == null)
      return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean leftToRight = true;
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Integer> currentLevel = new LinkedList<>();
      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll();

        // add the node to the current level based on the traverse direction
        if (leftToRight)
          currentLevel.add(currentNode.val);
        else
          currentLevel.add(0, currentNode.val);

        // insert the children of current node in the queue
        if (currentNode.left != null)
          queue.offer(currentNode.left);
        if (currentNode.right != null)
          queue.offer(currentNode.right);
      }
      result.add(currentLevel);
      // reverse the traversal direction
      leftToRight = !leftToRight;
    }

    return result;
 }

/******************************using single queue and level number***********************************/
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	List<List<Integer>> result = new ArrayList<>();
	if(root == null)
		return result;
	Queue<TreeNode> queue = new LinkedList<>();
	queue.add(root);
	int level = 0;
	while(!queue.isEmpty())
	{
		int size = queue.size();
		while(size > 0)
		{
			if(result.size() == level)
				result.add(new ArrayList<>());
			TreeNode current = queue.remove();
			if(level %2 == 0)
			{
				result.get(level).add(current.val);
			}
			else
				result.get(level).add(0, current.val);
			if(current.left != null)
				queue.add(current.left);
			if(current.right != null)
				queue.add(current.right);
			size--;
		}
		level++;
	}
	return result;
}

}
