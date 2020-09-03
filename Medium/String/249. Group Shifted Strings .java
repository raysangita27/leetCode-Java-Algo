/*
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of non-empty strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

Example:

Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Output: 
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
*/
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(strings == null || strings.length == 0)
            return result;
        HashMap<String, List<String>> map = new HashMap<>();
        for(String word : strings)
        {
            String key = convert(word.toCharArray());
            if(!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(word);
        }
        for(var list :map.values())
        {
            Collections.sort(list);
            result.add(list);
        }
        
        return result;
    }
    private String convert(char[] word)
    {
        int shift = 'z'-word[0];
       
        for(int i = 0; i< word.length; i++)
        {
            word[i] = word[i] + shift> 'z'?(char)((word[i]+shift-'z')+'a'-1): (char)(word[i]+shift);
        }
        return new String(word);
    }
}
