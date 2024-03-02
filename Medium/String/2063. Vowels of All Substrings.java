/*
Given a string word, return the sum of the number of vowels ('a', 'e', 'i', 'o', and 'u') in every substring of word.

A substring is a contiguous (non-empty) sequence of characters within a string.

Note: Due to the large constraints, the answer may not fit in a signed 32-bit integer. Please be careful during the calculations.

 

Example 1:

Input: word = "aba"
Output: 6
Explanation: 
All possible substrings are: "a", "ab", "aba", "b", "ba", and "a".
- "b" has 0 vowels in it
- "a", "ab", "ba", and "a" have 1 vowel each
- "aba" has 2 vowels in it
Hence, the total sum of vowels = 0 + 1 + 1 + 1 + 1 + 2 = 6. 
Example 2:

Input: word = "abc"
Output: 3
Explanation: 
All possible substrings are: "a", "ab", "abc", "b", "bc", and "c".
- "a", "ab", and "abc" have 1 vowel each
- "b", "bc", and "c" have 0 vowels each
Hence, the total sum of vowels = 1 + 1 + 1 + 0 + 0 + 0 = 3.
Example 3:

Input: word = "ltcd"
Output: 0
Explanation: There are no vowels in any substring of "ltcd".
 

Constraints:

1 <= word.length <= 105
word consists of lowercase English letters.

*/

class Solution {
    public long countVowels(String word) {
        if(word == null || word.length() == 0)
            return 0;
        long stringCount = 0;
        long len = word.length();
        for(int i = 0; i < len; i++)
        {
            if("aeiou".indexOf(word.charAt(i)) >= 0)
            {
                stringCount += (len - i) * (i+1);
            }
        }    
        return stringCount;
    }
}

/*
For each vowels s[i],
it could be in the substring starting at s[x] and ending at s[y],
where 0 <= x <= i and i <= y < n,
that is (i + 1) choices for x and (n - i) choices for y.

So there are (i + 1) * (n - i) substrings containing s[i].


*/
