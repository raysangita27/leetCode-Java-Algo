/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Example 2:

Input: n = 1, k = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20
1 <= k <= n
*/

class Solution {
     List<List<Integer>>  result ;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<List<Integer>>();
        helper(n,k, new ArrayList<>(), 1);
        return result;
        
    }
    private void helper(int n, int k, ArrayList<Integer>ans, int start)
    {
        if(k == 0)
        {
            result.add(new ArrayList<>(ans));
            return;
        }
        for(int i = start; i<= n; i++)
        {
            ans.add(i);
            helper(n, k-1, ans, i+1);
            ans.remove(ans.size()-1);
        }
    }
}
