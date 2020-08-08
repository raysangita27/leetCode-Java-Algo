/*
Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  In these strings like "heeellooo", we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".

For some given string S, a query word is stretchy if it can be made to be equal to S by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is 3 or more.

For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has size less than 3.  Also, we could do another extension like "ll" -> "lllll" to get "helllllooo".  If S = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S.

Given a list of query words, return the number of words that are stretchy. 

 

Example:
Input: 
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation: 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
 

Constraints:

0 <= len(S) <= 100.
0 <= len(words) <= 100.
0 <= len(words[i]) <= 100.
S and all words in words consist only of lowercase letters
*/

class Solution {
    public int expressiveWords(String S, String[] words) {
        if(S.length() == 0 || words.length == 0)
            return 0;
        int count = 0;
        for(String word : words)
        {
            if(checkWords(S,word))
                count++;
        }
        return count;
    }
    private boolean checkWords(String word1 , String word2)
    {
        
        int m = word1.length();
        int n = word2.length();
        int i = 0;
        int j = 0;
        
        
        while(i<m && j <n)
        {
            if(word1.charAt(i++) != word2.charAt(j++))
                return false;
            int c1 = 1;
            while(i <m && word1.charAt(i) == word1.charAt(i-1) )
            {
                c1++;
                i++;
            }
            int c2 = 1;
            while(j <n && word2.charAt(j) == word2.charAt(j-1) )
            {
                c2++;
                j++;
            }
            if(c1 == c2 || c2 <c1 && c1 >= 3)
                continue;
            return false;
        }
        return i == m && j == n;
    }
}
