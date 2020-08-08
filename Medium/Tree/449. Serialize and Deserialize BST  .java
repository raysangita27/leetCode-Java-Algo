/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        return generateSerialize(root, "");
    }
    private String generateSerialize(TreeNode root, String str)
    {
        if(root == null)
        {
            str += "Null,";
            return str;
        }
        str = str + String.valueOf(root.val) + ",";
        str = generateSerialize(root.left, str);
        str = generateSerialize(root.right, str);
        return str;
    }
        

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0)
            return null;
        String[] arr = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        return generateTree(list);
        
    }
    private TreeNode generateTree(List<String> list)
    {
        if(list.get(0).equals("Null"))
        {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = generateTree(list);
        root.right = generateTree(list);
        return root;
            
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
