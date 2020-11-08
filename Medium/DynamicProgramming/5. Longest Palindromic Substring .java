/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len == 0)
            return "";
        boolean [][] dp = new boolean[len][len];
        int start = 0;
        int maxLength = 1;
        dp[0][0] = true;
        for(int i = 0; i< len; i++)
            dp[i][i] = true;
        for(int i = 0; i<len-1; i++)
        {
            if(s.charAt(i) == s.charAt(i+1) )
            {
                dp[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }
        
        for(int L = 3; L<=len; L++)
        {
            for(int i = 0; i< len -L +1; i++)
            {
                int j = i+L-1;
                if(dp[i+1][j-1] && s.charAt(i) == s.charAt(j)  )
                {
                     dp[i][j] = true;
                     if(L > maxLength){
                         maxLength = L;
                         start = i;
                     }
                }
              
            }
        }
        return s.substring(start, start + maxLength);
    }
}

/*
Time Complexity : O(n2)
Space Complexity : O(n2)

*/
