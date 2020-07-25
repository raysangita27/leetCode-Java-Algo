/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

*/

class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if(len == 0)
            return 0;
        int[] dp = new int[len+1];
        if(s.charAt(0) == '0')
            return 0;
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<=len; i++)
        {
            if(s.charAt(i-1) >'0')
                dp[i] = dp[i-1];
            if(s.charAt(i-2)=='1' || s.charAt(i-2) == '2' && s.charAt(i-1) <'7')
                dp[i] +=dp[i-2];
        }
        return dp[len];
    }
}
