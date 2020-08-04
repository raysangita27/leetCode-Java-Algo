/*
Given an input string , reverse the string word by word. 

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Note: 

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.
Follow up: Could you do it in-place without allocating extra space?
*/

class Solution {
    public void reverseWords(char[] s) {
        if(s.length == 0)
            return;
        int start = 0; 
        int end = s.length -1;
        while(start <= end)
        {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start ++;
            end --;
        }
        start = 0;
        for(int i = 0; i< s.length; i++)
        {
            if(s[i] == ' ' )
            {
                end = i-1;
                while(start <= end )
                {
                    char temp = s[start];
                    s[start] = s[end];
                    s[end] = temp;
                    start ++;
                    end --;
                }
                start = i + 1;
            }
        }
        end = s.length-1;
        while(start <= end )
                {
                    char temp = s[start];
                    s[start] = s[end];
                    s[end] = temp;
                    start ++;
                    end --;
                }
        
    }
}
