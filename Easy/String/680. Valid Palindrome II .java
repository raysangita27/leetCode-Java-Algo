/*
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
*/
class Solution {
    public boolean validPalindrome(String s) {
        int len = s.length();
        if(len <=1)
            return true;
        int i = 0; 
        int j = len -1;
        while( i <= j)
        {
            if(s.charAt(i) == s.charAt(j))
            {
                i++;
                j--;
            }
            else 
            {
                return isValid(s,i+1 , j) || isValid(s, i , j-1);
                    
            }
        }
        return true;
    }
    boolean isValid(String s, int start, int end)
    {
        while(start <= end)
        {
            if(s.charAt(start) == s.charAt(end))
            {
                start++;
                end--;
            }
            else if(s.charAt(start) != s.charAt(end))
            {
                return false;
            }
        }
        return true;
    }
}
