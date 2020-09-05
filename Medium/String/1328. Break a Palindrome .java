/*
Given a palindromic string palindrome, replace exactly one character by any lowercase English letter so that the string becomes the lexicographically smallest possible string that isn't a palindrome.

After doing so, return the final string.  If there is no way to do so, return the empty string.

 

Example 1:

Input: palindrome = "abccba"
Output: "aaccba"
Example 2:

Input: palindrome = "a"
Output: ""
 

Constraints:

1 <= palindrome.length <= 1000
palindrome consists of only lowercase English letters.
*/

class Solution {
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        if(len <= 1)
            return "";
        int i = 0;
        // Keep traversing until u find a character other than 'a'.. or if u find another character but it is in the mid of palindrome, and changing it won't make any difference.
  
        while(i < len && (palindrome.charAt(i)=='a' ||(palindrome.charAt(i)>'a' &&len%2 != 0 && i == (len/2)) ) )
            i++;
        // if i goes till n-1 i.e all characters are 'a', replace last by b otherwise replace ith character by 'a'          
        return i<len-1 ? palindrome.substring(0,i)+'a'+palindrome.substring(i+1) : palindrome.substring(0, len-1)+'b';
    }
}
