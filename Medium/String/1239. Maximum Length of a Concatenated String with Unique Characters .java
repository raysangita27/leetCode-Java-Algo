/*
Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

Return the maximum possible length of s.

 

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible solutions are "chaers" and "acters".
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
 

Constraints:

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lower case English letters.
*/
class Solution {
    public int maxLength(List<String> arr) {
        int len = arr.size();
        int[] set = new int[26];
        return findTheLength(arr, 0, 0,set);
    }
    int findTheLength(List<String>  arr, int index, int len, int[] set)
    {
        if(index >= arr.size())
            return len;
        boolean isunique = true;
        char[] charr = arr.get(index).toCharArray();
        for(char c : charr)
        {
            if(++set[c-'a'] >1)
            {
                isunique = false;
            }
            
        }
        int uniqCount = 0;
        if(isunique)
        {
            uniqCount = findTheLength(arr, index+1, len + charr.length, set );
        }
        for(char c : charr)
            set[c - 'a']--;
        return Math.max(uniqCount, findTheLength(arr, index+1, len , set ));
        
    }
}
