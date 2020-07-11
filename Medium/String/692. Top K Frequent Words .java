/*
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
*/

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String s : words)
        {
            if(map.containsKey(s) )
                map.put(s, map.get(s)+1);
            else
                map.put(s,1);
        }
        List<Map.Entry<String, Integer>> list = new  ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                if(o1.getValue() == o2.getValue() )
                    return o1.getKey().compareTo(o2.getKey());
                else
                    return o2.getValue() - o1.getValue();
            }
        } );
        int i = 0;
        for(var str : list)
        {
            if(i == k)
                break;
            result.add(str.getKey() );
            i++;
        }
        return result;
    }
}
