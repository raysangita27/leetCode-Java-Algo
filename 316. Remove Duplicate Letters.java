/*
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.
 */

class Solution {
    public String removeDuplicateLetters(String s) {

        Stack<Character> stack = new Stack<>();

        // this lets us keep track of what's in our solution in O(1) time
        HashSet<Character> seen = new HashSet<>();

        // this will let us know if there are any more instances of s[i] left in s
        HashMap<Character, Integer> last_occurrence = new HashMap<>();
        for(int i = 0; i < s.length(); i++) last_occurrence.put(s.charAt(i), i);

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // we can only try to add c if it's not already in our solution
            // this is to maintain only one of each character
            if (!seen.contains(c)){
                // if the last letter in our solution:
                //     1. exists
                //     2. is greater than c so removing it will make the string smaller
                //     3. it's not the last occurrence
                // we remove it from the solution to keep the solution optimal
                while(!stack.isEmpty() && c < stack.peek() && last_occurrence.get(stack.peek()) > i){
                    seen.remove(stack.pop());
                }
                seen.add(c);
                stack.push(c);
            }
        }
    StringBuilder sb = new StringBuilder(stack.size());
    for (Character c : stack) sb.append(c.charValue());
    return sb.toString();
    }
}

/*
Complexity Analysis

Time complexity : O(N)O(N). Although there is a loop inside a loop, the time complexity is still O(N)O(N). This is because the inner while loop is bounded by the total number of elements added to the stack (each time it fires an element goes). This means that the total amount of time spent in the inner loop is bounded by O(N)O(N), giving us a total time complexity of O(N)O(N)

Space complexity : O(1)O(1). At first glance it looks like this is O(N)O(N), but that is not true! seen will only contain unique elements, so it's bounded by the number of characters in the alphabet (a constant). You can only add to stack if an element has not been seen, so stack also only consists of unique elements. This means that both stack and seen are bounded by constant, giving us O(1)O(1) space complexity.
*/
