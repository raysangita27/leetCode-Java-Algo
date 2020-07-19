/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
*/
class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        Stack<Character> stk = new Stack<Character>();
        for(int i = 0; i<len; i++)
        {
            if(s.charAt(i) == ']' || s.charAt(i) == '}' || s.charAt(i) == ')' )
            {
                if(!stk.isEmpty())
                {
                    if(!isValid(s.charAt(i), stk.pop()) )
                        return false;
                }
                else
                    return false;
            }
            else
                stk.push(s.charAt(i));
        }
        if(!stk.isEmpty())
            return false;
        return true;
    }
    boolean isValid(char end, char start)
    {
        if((start == '(' && end ==')') || (start == '{' && end =='}') || (start == '[' && end ==']') )
            return true;
        return false;
    }
}
