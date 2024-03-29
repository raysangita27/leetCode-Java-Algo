/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        int len = strs.length;
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while(i < strs[0].length() && j< strs[len-1].length())
        {
            if(strs[0].charAt(i) == strs[len-1].charAt(j))
            {
                sb.append(strs[0].charAt(i));
                i++;
                j++;
            }
            else
                break;
        }
        return sb.toString();
    }
}


/*******************************without sorting O(S) s= sum of length of all words**********************/
public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    for (int i = 0; i < strs[0].length() ; i++){
        char c = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j ++) {
            if (i == strs[j].length() || strs[j].charAt(i) != c)
                return strs[0].substring(0, i);             
        }
    }
    return strs[0];
}
