/*
Given a list of words, each word consists of English lowercase letters.

Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.  For example, "abc" is a predecessor of "abac".

A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.

Return the longest possible length of a word chain with words chosen from the given list of words.

 

Example 1:

Input: ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: one of the longest word chain is "a","ba","bda","bdca".
 

Note:

1 <= words.length <= 1000
1 <= words[i].length <= 16
words[i] only consists of English lowercase letters.
*/
class Solution {
    public int longestStrChain(String[] words) {
        if(words == null || words.length == 0)
            return 0;
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String o1, String o2)
            {
                return o1.length() - o2.length();
            }
        });
        HashMap<String, Integer> map = new HashMap<>();
        int maxLen = 0;
        for(var word : words)
        {
            int longestSub = 0;
            for(int i = 0; i< word.length(); i++)
            {
                String subWord = word.substring(0,i) + word.substring(i+1);
                longestSub = Math.max(longestSub, map.getOrDefault(subWord, 0) + 1);
            }
            map.put(word, longestSub);
            maxLen = Math.max(maxLen, longestSub);
        }
        return maxLen;
        
    }
    
    /*********************************************************** Approach *********************************************
Create a map with the count of each occurence of the substring present in word array as we proceed through the word array. We sort it because we need increasing order of each word length for this algorithm to work. We identify single letter words as parents and find what children we have or what children have these single letters as parents. Also, we keep a track of the maximum we see everytime to return it ultimately.
**Example walkthrough:

For the first example, we have words = ["a","b","ba","bca","bda","bdca"]. Let's identify this with first letter "a" (let's call it parent). Now I need to check what is the next one, "b" (call it parent, as it is a single letter). Add both to the HashMap. Now, next we have "ba". We check if we have a parent, either "b" or "a" and if yes, we call it child and store it by adding 1. Similarly we traverse through all and we will have in our HashMap this structure.
map after all traversals {a=1, bca=3, b=1, bda=3, bdca=4, ba=2}
As you can see, we have identified which child is what level to the parent, i.e. single letter. Also, everytime, we do this, let's keep a count of the max level of child we have seen through the loop and ultimately return that.
*/
}
