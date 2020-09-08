/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
*/

class Solution {
    List<List<String>> result ;
    public List<List<String>> partition(String s) {
        result = new ArrayList<List<String>>();
        if(s.length() == 0)
            return result;
        helper(s, new ArrayList<>(), 0);
        return result;
    }
    private void helper(String s, ArrayList<String>  ans, int ind)
    {
        if(ind == s.length()){
            result.add(new ArrayList<>(ans));
            return ;
        }
        for(int i = ind; i < s.length(); i++)
        {
            if(isPalindrome(s,ind,i)){
                ans.add(s.substring(ind,i+1));
                helper(s, ans, i+1);
                ans.remove(ans.size()-1);
                
            }
        }
        
    }
    private boolean isPalindrome(String s, int i , int j){
        while(i <j)
        {
            if(s.charAt(i)!= s.charAt(j))
                return false;
            i++;
            j--;
        }
        return  true;
    }
}
