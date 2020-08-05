/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

class Solution {
    List<String> result;
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<String>();
        if(digits.length() == 0)
            return result;
        String[] dict = {" ", " ","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        findStringList(digits, 0, "", dict);
        return result;
            
    }
    void findStringList(String digits, int index, String ans,  String[] dict)
    {
        if(index >= digits.length())
        {
            result.add(ans);
            return;
        }
        String str = dict[digits.charAt(index)-'0'];
        for(int j = 0; j< str.length(); j++)
            findStringList(digits, index + 1, ans + str.charAt(j), dict);
    }
}
