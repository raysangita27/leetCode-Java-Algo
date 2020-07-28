/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"

*/

class Solution {
    public String decodeString(String s) {
        int len = s.length();
        if(len == 0)
            return "";
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(c == ']')
            {
                String temp = "";
                // temp will generate the string inside []
                while(stk.peek()!='[' && !stk.isEmpty())
                {
                    temp += stk.pop();
                }
                stk.pop();
                String count = "";
                //count will generate the number 
                while(!stk.isEmpty() && Character.isDigit(stk.peek()) )
                    count = stk.pop()+count;
                int key = Integer.parseInt(count);
                
                
                while(key > 0)
                {
                    for(int i =temp.length()-1; i >= 0; i--)
                        stk.push(temp.charAt(i));
                    key--;
                }
                
            }
            else
            {
                stk.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(stk.size() > 0)
            sb.append(stk.pop());
        return sb.reverse().toString();
    }
}
