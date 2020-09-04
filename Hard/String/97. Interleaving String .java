/*
Given s1, s2, and s3, find whether s3 is formed by the interleaving of s1 and s2.

 

![Example](https://github.com/raysangita27/leetCode-Java-Algo/blob/master/images/interleave.jpg)


Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true
 

Constraints:

0 <= s1.length, s2.length <= 100
0 <= s3.length <= 200
s1, s2, and s3 consist of lower-case English letters.
*/

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if((s1.length()+ s2.length()) != s3.length())
            return false;
        boolean [][] dp = new boolean[s1.length()+1][s2.length()+1];
        for(int i= 0; i<= s1.length(); i++)
        {
            for(int j = 0; j<= s2.length(); j++)
            {
                if(i == 0 && j == 0)
                    dp[i][j] = true;
                else if(i == 0 )
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1)== s3.charAt(i+j-1);
                else if(j == 0)
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                else
                    dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) ||
                    (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
                    
            }
            
        }
        return dp[s1.length()][s2.length()];
    }
}
