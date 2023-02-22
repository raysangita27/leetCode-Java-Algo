/*
You are given two 0-indexed strings word1 and word2.

A move consists of choosing two indices i and j such that 0 <= i < word1.length and 0 <= j < word2.length and swapping word1[i] with word2[j].

Return true if it is possible to get the number of distinct characters in word1 and word2 to be equal with exactly one move. Return false otherwise.

 

Example 1:

Input: word1 = "ac", word2 = "b"
Output: false
Explanation: Any pair of swaps would yield two distinct characters in the first string, and one in the second string.
Example 2:

Input: word1 = "abcc", word2 = "aab"
Output: true
Explanation: We swap index 2 of the first string with index 0 of the second string. The resulting strings are word1 = "abac" and word2 = "cab", which both have 3 distinct characters.
Example 3:

Input: word1 = "abcde", word2 = "fghij"
Output: true
Explanation: Both resulting strings will have 5 distinct characters, regardless of which indices we swap.
 

Constraints:

1 <= word1.length, word2.length <= 105
word1 and word2 consist of only lowercase English letters.

*/

class Solution {
    public boolean isItPossible(String word1, String word2) {
        if(word1 == null && word2 == null)
            return true;

        HashMap<Character, Integer> count1 = new HashMap<>();
        HashMap<Character, Integer> count2 = new HashMap<>();

        for(char c : word1.toCharArray())
        {
            count1.put(c, count1.getOrDefault(c, 0) +1);
        }

        for(char c : word2.toCharArray())
        {
            count2.put(c, count2.getOrDefault(c, 0) +1);
        }

        for(char i = 'a' ; i <= 'z'; i++)
        {
            for(char j = 'a'; j <= 'z'; j++)
            {
                if(!count1.containsKey(i) || !count2.containsKey(j))
                    continue;
                if(count1.containsKey(i)){
                    count1.put(i, count1.get(i)-1);
                    if(count1.get(i) <= 0)
                        count1.remove(i);
                }
                if(count2.containsKey(j)){
                    count2.put(j, count2.get(j)-1);
                    if(count2.get(j) <= 0)
                        count2.remove(j);
                }

                count1.put(j, count1.getOrDefault(j, 0)+1);
                count2.put(i, count2.getOrDefault(i, 0)+1);

                if(count1.size() == count2.size())
                    return true;
                else
                {
                    if(count2.containsKey(i)){
                        count2.put(i, count2.get(i)-1);
                        if(count2.get(i) <= 0)
                            count2.remove(i);
                    }
                    if(count1.containsKey(j)){
                        count1.put(j, count1.get(j)-1);
                        if(count1.get(j) <= 0)
                            count1.remove(j);
                    }

                    count2.put(j, count2.getOrDefault(j, 0)+1);
                    count1.put(i, count1.getOrDefault(i, 0)+1);
                }
            }
        }
        return false;

    }
    
}
