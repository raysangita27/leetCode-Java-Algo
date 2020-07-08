/*
Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.
 

Note: You may assume the string contains only lowercase English letters.
*/
class Solution {
    public int firstUniqChar(String s) {
        int len = s.length();
        if(len == 0)
            return -1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < len; i++)
        {
            if(map.containsKey(s.charAt(i) ) )
                map.put(s.charAt(i), map.get(s.charAt(i))+1 );
            else
                map.put(s.charAt(i), 1);
        }
        for(int i = 0; i < len; i++)
        {
            if(map.get(s.charAt(i) ) == 1)
                return i;
        }
        return -1;
    }
}
