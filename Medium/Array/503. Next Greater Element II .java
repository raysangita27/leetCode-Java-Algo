/*
Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.
Note: The length of given array won't exceed 10000.
*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stk = new Stack<>();
        int len = nums.length;
        Arrays.fill(result, -1);
        for(int i = 0; i < 2*nums.length; i++)
        {
            while(!stk.isEmpty() && nums[stk.peek()] < nums[i % len])
            {
                result[stk.pop()] = nums[i % len];
            }
            stk.push(i % len);
        }
        return result;
    }
}
/*
Explanation
Loop once, we can get the Next Greater Number of a normal array.
Loop twice, we can get the Next Greater Number of a circular array


Complexity
Time O(N) for one pass
Spce O(N) in worst case
*/
