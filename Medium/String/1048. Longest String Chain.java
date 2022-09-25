/*
You are given an array of words where each word consists of lowercase English letters.

wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.

For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.

Return the length of the longest possible word chain with words chosen from the given list of words.

 

Example 1:

Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
Example 2:

Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
Output: 5
Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
Example 3:

Input: words = ["abcd","dbqca"]
Output: 1
Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 16
words[i] only consists of lowercase English letters.

*/
class Solution {
    Map<String, Integer> map;
    public int longestStrChain(String[] words) {
        if(words == null || words.length == 0)
            return 0;
        HashSet<String> set = new HashSet<>();
        for(String word : words)
            set.add(word);
        map = new HashMap<>();
        int ans = 0;
        for(String word : words)
        {
            ans = Math.max(ans, dfs(word, set));
        }
        return ans;
    }
    public int dfs(String word, HashSet<String> set)
    {
        if(map.containsKey(word))
            return map.get(word);
        int maxLen = 1;
        StringBuilder sb = new StringBuilder(word);
        for(int i = 0; i < word.length(); i++)
        {
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            if(set.contains(newWord))
            {
                int curLen =  1+ dfs(newWord, set);
                maxLen = Math.max(maxLen, curLen);
            }
            sb.insert(i, word.charAt(i));
        }
        map.put(word, maxLen);
        return maxLen;
    }
}

/*
TimeComplexity : O(N*L^2)

*/
