/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
*/

class Solution {
    final int MAX = 256;
    public String minWindow(String s, String t) {
        int N = s.length();
        int n = t.length();
        if(n == 0 || N == 0)
            return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++)
        {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }
        int minLen = Integer.MAX_VALUE;
        int start = 0; 
        int end = 0;
        int count = 0;
        String res = "";
        for(; end < N; end++)
        {
            if(map.containsKey(s.charAt(end))){
                map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
                if(map.get(s.charAt(end)) >= 0)
                    count ++;
            }
            while(count == t.length())
            {
                if(minLen > end - start +1)
                {
                    minLen = end - start +1;
                    res = s.substring(start, end + 1);
                }
                if(map.containsKey(s.charAt(start))){
                    map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                    if(map.get(s.charAt(start)) > 0)
                        count --;
                }
                start ++;
            }
          
        }
        return res;
    }
}
