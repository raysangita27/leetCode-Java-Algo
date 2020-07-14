/*
Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.

 

Example 1:

Input: "ab-cd"
Output: "dc-ba"
Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 

Note:

S.length <= 100
33 <= S[i].ASCIIcode <= 122 
S doesn't contain \ or "
*/

class Solution {
    public String reverseOnlyLetters(String S) {
        char[] str = S.toCharArray();
        int len = str.length;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int j = len-1;
        while(i <= j)
        {
           
            if(Character.isLetter(str[i]) && Character.isLetter(str[j]) )
            {
                
                char t = str[i];
                str[i] = str[j];
                str[j] = t;
                i++;
                j--;
            }
            else if(!Character.isLetter(str[i]))
                i++;
            else if(!Character.isLetter(str[j]))
                j--;
        }
        for(char c : str)
            sb.append(c);
        return sb.toString();
    }
}
