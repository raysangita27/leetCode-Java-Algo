/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        if(n == 0)
            return result;
        generateUtil(n, 0, 0, "");
        return result;
    }
    void generateUtil(int n , int openCount, int closeCount, String ans)
    {
        if(ans.length() == 2*n)
        {
            result.add(ans);
            return;
        }
        if(openCount < n)
            generateUtil(n, openCount + 1, closeCount, ans + "(");
        if(closeCount < openCount)
            generateUtil(n, openCount , closeCount + 1, ans + ")");
        
    }
}
