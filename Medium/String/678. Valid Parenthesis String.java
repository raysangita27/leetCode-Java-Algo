/*
Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true
 

Constraints:

1 <= s.length <= 100
s[i] is '(', ')' or '*'.

*/

class Solution {
    public boolean checkValidString(String s) {
        if(s == null || s.length() == 0)
            return true;

        int leftCount = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(' || s.charAt(i) == '*')
                leftCount++;
            else
                leftCount--;
            if(leftCount < 0)    // We know we have unbalanced parenthesis
                return false;
        }    
       if(leftCount == 0)
        return true;

        int rightCount = 0;
        for(int i = s.length() -1 ; i >= 0; i--)
        {
            if(s.charAt(i) == ')' || s.charAt(i) == '*')
                rightCount++;
            else
                rightCount--;
            if(rightCount < 0)     // We know we have unbalanced parenthesis
               return false;
        }

      // Here we know we have never been unbalanced parsing from left to right e.g. ')('
    // We've also already substituted '*' either by '(' or by ')'
    // So we only have 3 possible scenarios here:
    // 1. We had the same amount of '(' and ')'
    // 2. We had more '(' then ')' but enough '*' to substitute
        return true;
    }
}
