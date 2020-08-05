/*
Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
*/

class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(len == 0)
            return " ";
        Deque<Character> dQ = new ArrayDeque<Character>();
        int index = 0;
        
        for(char c : num.toCharArray())
        {
            while(!dQ.isEmpty() && dQ.getLast() > c && index != k)
            {
                dQ.removeLast();
                index++;
            }
            dQ.addLast(c);
        }
        StringBuilder sb = new StringBuilder();
        while(index != k && !dQ.isEmpty())
        {
            dQ.removeLast();
            index++;
        }
        while(!dQ.isEmpty() && dQ.getFirst() == '0')
            dQ.removeFirst();
        
        while(!dQ.isEmpty())
            sb.append(dQ.removeFirst());
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
/*
It is a classical greedy problem. In order to make the new number to be the smallest possible. We should put smaller digits before bigger digits. In this problem, we can't change the position of the digits, but we can remove some digits. So we need to remove bigger digits as possible as we can.
we define a Deque to record the digits we want to keep.
The idea is the same as insert sort, but we don't need to keep all numbers in the deque.
we use a loop to add digits to the deque

we add a digit into the deque when the deque is empty.
when we add digit and deque is not empty, we need to compare it and the last element. if the digit is less than the last element, we remove the last element and compare it with the next element until the deque becomes empty or finds the element is less than or equal to the digit we add. When we remove the element from deque, the k minus 1. if k is zero, we can't remove the element.
Add the digit into the deque.
After the loop, we need to deal with two things:

k != 0. we need to remove more digits from the deque. In this situation, the digits in deque are in ascending order. So we can just remove the last k element.
the deque start with '0'. using a while loop to remove the zero.
*/
