/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
*/

class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if(n == 0)
            return 0;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i<n; i++)
        {
            if(s.charAt(i)=='(')
                stk.push(i);
            else
            {
                if(!stk.isEmpty())
                {
                    if(s.charAt(i)==')' && s.charAt(stk.peek())=='(')
                        stk.pop();
                    else
                        stk.push(i);
                }
                else
                    stk.push(i);
            }
        }
        if(stk.isEmpty())
            return n;
        int a = n;
        int b = 0;
        int maxLen= 0;
        while(!stk.isEmpty())
        {
            b = stk.pop();
            maxLen = Math.max(maxLen, a-b-1);
            a = b;
        }
        maxLen = Math.max(maxLen, a);
        return maxLen;
    }
}
/************************************************************************
1. Scan the string from beginning to end.
2. If current character is '(',
push its index to the stack. If current character is ')' and the
character at the index of the top of stack is '(', we just find a
matching pair so pop from the stack. Otherwise, we push the index of
')' to the stack.
3. After the scan is done, the stack will only
contain the indices of characters which cannot be matched. Then
let's use the opposite side - substring between adjacent indices
should be valid parentheses.
4. If the stack is empty, the whole input
string is valid. Otherwise, we can scan the stack to get longest
valid substring as described in step 3.
