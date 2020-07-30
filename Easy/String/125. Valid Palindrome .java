/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

Input: "0P"
Output: false

Input: ".a"
Output: true
 

Constraints:

s consists only of printable ASCII characters.
*/

class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1)
            return true;
        
        int len = s.length();
        int i = 0;
        int j = len -1;
        boolean flag = false;
        while( i < j){
        
            while( i< j && !Character.isLetterOrDigit((s.charAt(i))))
                i++;
            while( i < j && !Character.isLetterOrDigit((s.charAt(j))))
                j--;
            if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j)) )
            {
                flag = false;
                System.out.println(s.charAt(i) +"-> "+ s.charAt(j));
                 return false;   
            }
        
            i++;
            j--;
                   
        }
      return true;
    }
}
