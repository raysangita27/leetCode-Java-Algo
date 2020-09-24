/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        String encodeS = generate(S); 
        String encodeT = generate(T);  
        return encodeS.equals(encodeT);
    }
    public String generate(String S)
    {
        if(S.length() == 0 ||(S.length() == 1 && S.charAt(0)!='#') )
            return S;
        Stack<Character> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray())
        {
            if(c == '#')
            {
                if(!stk.isEmpty())
                {
                    stk.pop();
                }
            }
            else
                stk.push(c);
        }
        while(!stk.isEmpty())
            sb.append(stk.pop());
        return sb.toString();
    }
        
}
