/*
Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
Note:

S will consist of lowercase letters and have length in range [1, 500].
*/
class Solution {
    public String reorganizeString(String S) {
        int len = S.length();
        if(len == 0)
            return "";
        int[] count = new int[26];
        for(int i = 0; i < len; i++)
        {
            count[S.charAt(i) -'a']++;
        }
        int max = 0;
        int letter = 0;
        for(int i = 0; i <26 ; i ++)
        {
            if(count[i] > max)
            {
                max = count[i];
                letter = i;
                
            }
        }
        if(max > (len +1)/2)
            return "";
        char[] result = new char[S.length()];
        int ind = 0;
        while(count[letter] > 0)
        {
            result[ind] = (char)(letter +'a');
            ind += 2;
            count[letter]--;
            
        }
        for(int i = 0; i < 26; i++)
        {
            while(count[i] > 0)
            {
                if(ind >= len)
                    ind = 1;
            
            result[ind] = (char)(i + 'a');
            ind += 2;
            count[i]--;
            }
        }
        return String.valueOf(result);
        
        
    }
}

//TimeComplexity : O(n)
