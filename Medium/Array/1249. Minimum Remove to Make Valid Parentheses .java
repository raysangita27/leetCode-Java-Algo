/*
Given a string s of '(' , ')' and lowercase English characters. 

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
Example 4:

Input: s = "(a(b(c)d)"
Output: "a(b(c)d)"
 

Constraints:

1 <= s.length <= 10^5
s[i] is one of  '(' , ')' and lowercase English letters.
*/

class Solution {
    public String minRemoveToMakeValid(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for(char c : s.toCharArray())
        {
            if(c =='(')
                counter++;
            else if(c == ')')
            {
                if(counter == 0)
                    continue;
                counter--;
            }
            sb.append(c);
        }

        StringBuilder result = new StringBuilder();
        for(int i = sb.length()-1; i>=0; i--)
        {
            if(sb.charAt(i) == '(' && counter--> 0)
                continue;
            result.append(sb.charAt(i));
        }
        return result.reverse().toString();
    }
}
