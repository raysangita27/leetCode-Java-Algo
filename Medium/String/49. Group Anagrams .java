/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>  result = new ArrayList<List<String>>();
        int len = strs.length;
        if(len == 0)
            return result;
        HashMap<String, List<String>> map = new HashMap<>();
        int [] count = new int[26];
        for(String word : strs)
        {
            Arrays.fill(count, 0);
            for(int i = 0; i< word.length() ; i++ )
                count[word.charAt(i) - 'a'] ++;
            StringBuilder key = new StringBuilder();
            for(int i = 0; i<26; i++)
            {
                key.append('#');
                key.append(count[i]);
            }
            if(!map.containsKey(key.toString()))
                map.put(key.toString(), new ArrayList<String>());
            map.get(key.toString()).add(word);
        }
        result.addAll(map.values());
        return result;
            
    }
}
