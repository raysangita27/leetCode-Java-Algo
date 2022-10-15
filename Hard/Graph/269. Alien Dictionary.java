/*
There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.

You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted lexicographically by the rules of this new language.

Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.

A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in s comes before the letter in t in the alien language. If the first min(s.length, t.length) letters are the same, then s is smaller if and only if s.length < t.length.

 

Example 1:

Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"
Example 2:

Input: words = ["z","x"]
Output: "zx"
Example 3:

Input: words = ["z","x","z"]
Output: ""
Explanation: The order is invalid, so return "".
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of only lowercase English letters.
*/

class Solution {
    public String alienOrder(String[] words) {
        if(words.length == 0)
            return "";
        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        for(String word : words)
        {
            for(char c : word.toCharArray())
            {
                graph.put(c, new ArrayList<>());
                indegree.put(c, 0);
            }
        }
        
        for(int i = 0; i < words.length-1; i++)
        {
            String word1 = words[i];
            String word2 = words[i+1];
            if(word1.length() > word2.length() && word1.startsWith(word2))
                return "";
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++)
            {
                char start = word1.charAt(j);
                char next = word2.charAt(j);
                if(start != next)
                {
                    graph.get(start).add(next);
                    indegree.put(next, indegree.get(next)+1);
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<>();
        for(char c : indegree.keySet())
        {
            if(indegree.get(c) == 0)
                q.add(c);
        }
        StringBuilder sb = new StringBuilder();
        
        while(!q.isEmpty())
        {
            char cur = q.poll();
            sb.append(cur);
            for(char next : graph.get(cur))
            {
                indegree.put(next, indegree.get(next)-1);
                if(indegree.get(next) == 0)
                    q.add(next);
            }
        }
        if(sb.length() != indegree.size())
            return "";
        return sb.toString();
        
    }
}
/*************TimeComplexity : O(V+N)**************************
