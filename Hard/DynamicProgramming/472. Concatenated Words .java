/*
Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.
A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

Example:
Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
 "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
Note:
The number of elements of the given array will not exceed 10,000
The length sum of elements in the given array will not exceed 600,000.
All the input string will only include lower case letters.
The returned elements order does not matter.
*/

class Solution {
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String>  result = new ArrayList<String>();
        if(words.length == 0 )
            return result;
        Set<String> set = new HashSet<>();
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a, String b)
            {
                return a.length() - b.length();
            }
        });
        for(int i = 0; i<words.length; i++)
        {
            if(canFormWord(words[i], set))
            {
                result.add(words[i]);
            }
            set.add(words[i]);
        }
        return result;
    }
    
    private boolean canFormWord(String word, Set<String> dict)
    {
        if(dict.size() == 0)
            return false;
        boolean[] dp = new boolean[word.length() +1];
        dp[0] = true;
        for(int i = 1; i<= word.length(); i++ )
        {
            for(int j = 0; j<i; j++)
            {
                if(dict.contains(word.substring(j,i)) && dp[j])
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}

/********************************************************Trie Imp***********************************************************/
class Solution {
    List<String> result;
    TrieNode root ;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        result = new ArrayList<String>();
        if(words == null || words.length == 0)
            return result;
        root = new TrieNode();
        insert(words);
        for(String word : words)
        {
            if(dfs(word, 0, 0))
                result.add(word);
        }
        return result;
    }
    public boolean dfs(String word, int index, int count)
    {
        if(index == word.length())
            return count >= 2;
        
        TrieNode node = root;
        for(int i = index; i < word.length(); i++)
        {
            if(node.link[word.charAt(i)-'a'] == null)
                return false;
            node = node.link[word.charAt(i)-'a'];
            if(node.isEnd)
            {
                if(dfs(word, i+1, count+1))
                    return true;
            }
        }
        return false;  
    }
    
    public void insert(String[] words)
    {
        
        for(String word : words)
        {
            TrieNode node = root;
            for(char c : word.toCharArray())
            {
                if(node.link[c-'a'] == null)
                    node.link[c - 'a'] = new TrieNode();
                node = node.link[c - 'a'];
            }
            node.isEnd = true;
        }
    }
}

class TrieNode {
    TrieNode[] link;
    boolean isEnd;
    TrieNode()
    {
        link = new TrieNode[26];
        isEnd = false;
    }
}
