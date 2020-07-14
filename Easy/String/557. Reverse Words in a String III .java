/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
*/

class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        if(len == 0)
            return s;
        Stack<Character> stk = new Stack<Character>();
        String result= "";
        for(int i = 0; i<len; i++)
        {
            if(s.charAt(i)==' ' )
            {
                while(!stk.isEmpty())
                    result += stk.pop();
                result+= " ";
            }
            else
                stk.push(s.charAt(i));
        }
        while(!stk.isEmpty())
            result += stk.pop();
        return result;
    }
}
