/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".
*/
class Solution {
    public String reverseVowels(String s) {
        int len = s.length();
        if(len <=1)
            return s;
        int start = 0;
        int end = len-1;
        char[] str = s.toCharArray();
        while(start <= end)
        {
            while(end >= start && !checkVowels(str[end]) )
                end--;
            while(start <= end && !checkVowels(str[start]) )
                start ++;
            if(start != end && checkVowels(str[start]) && checkVowels(str[end])  )
            {
                char temp = str[start];
                str[start] = str[end];
                str[end] = temp;
                start++;
                end--;
            }
            else 
                break;
            
        }
        return new String(str);
    }
    
    boolean checkVowels(char c)
    {
        if(c != 'e' && c !='a' && c!='i' && c!='o' && c!='u' && c != 'E' && c !='A' && c!='I' && c!='O' && c!='U')
            return false;
        return true;
    }
        
}
