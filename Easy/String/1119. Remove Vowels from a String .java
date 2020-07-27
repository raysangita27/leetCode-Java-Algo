/*
Given a string S, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.

 

Example 1:

Input: "leetcodeisacommunityforcoders"
Output: "ltcdscmmntyfrcdrs"
Example 2:

Input: "aeiou"
Output: ""
 

Note:

S consists of lowercase English letters only.
1 <= S.length <= 1000

*/

class Solution {
    public String removeVowels(String S) {
        int len = S.length();
        if(len == 0)
            return S;
        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray() )
        {
            if(c != 'a' && c != 'e' && c != 'i'  && c != 'o' && c != 'u')
                sb.append(c);
        } 
        return sb.toString();
    }
}
