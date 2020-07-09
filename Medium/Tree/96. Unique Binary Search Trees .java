/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   */
   
class Solution {
    public int numTrees(int n) {
        if(n == 0)
            return 0;
        int [] tree = new int[n+1];
        tree[0] = 1;
        tree[1] = 1;
        for(int i = 2; i<= n; i++)
        {
            for(int j = 1; j<=i; j++)
                tree[i] = tree[i]+ (tree[j-1] * tree[i-j]);
        }
        return tree[n];
    }
}
