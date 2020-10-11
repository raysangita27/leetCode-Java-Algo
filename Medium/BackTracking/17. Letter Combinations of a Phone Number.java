/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/
class Solution {
    List<String> result;
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if(digits.length() == 0)
            return result;
        String[] dict = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};    
        generate(digits, 0, dict, "");
        return result;
    }
    public void generate(String digits, int ind, String[] dict, String ans)
    {
        if(ind == digits.length())
        {
            result.add(ans);
            return;
        }
        String word = dict[digits.charAt(ind)-'0'];
        for(int j = 0; j < word.length(); j++)
        {
            generate(digits, ind+1, dict, ans+word.charAt(j));
        }
    }
}
/*
Complexity Analysis

Time complexity : O(3^N * 4^M) where N is the number of digits in the input that maps to 3 letters (e.g. 2, 3, 4, 5, 6, 8) and M is the number of digits in the input that maps to 4 letters (e.g. 7, 9), and N+M is the total number digits in the input.

Space complexity : O(3^N * 4^M) since one has to keep 3^N to 4^M

  */
