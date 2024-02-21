/*
Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0)
            return temperatures;

        int len = temperatures.length;
        int[] ans = new int[len];
        Stack<Integer> stk = new Stack<>();
        for(int i = len-1; i >= 0; i--)
        {
            //if stack contains less temparature than current one removing that
            while(!stk.isEmpty() && temperatures[stk.peek()] <= temperatures[i])
                stk.pop();
            //if stack is empty , no warmer value present setting 0
            if(stk.isEmpty())
                ans[i] = 0;
            // else peek of the stack index contains nearest warm value.
            else
            {
                int index = stk.peek();
                ans[i] = index-i;
            }
            stk.push(i);
        }    
        return ans;
    }
}
