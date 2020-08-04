/*
Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
*/

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        if(len == 0)
            return new int[]{};
        int [] res = new int[len];
        Stack<int[]> stk = new Stack<>();
        for(int i = 0; i< len ; i++)
        {
            if(stk.isEmpty() || T[i] <= stk.peek()[0])
                stk.push(new int[]{T[i],i});
            else
            {
                while(!stk.isEmpty() && stk.peek()[0] < T[i])
                {
                    int[] temp = stk.pop();
                    res[temp[1]] = i- temp[1];
                }
                stk.push(new int[]{T[i],i});
            }
        }
        return res;
    }
}
