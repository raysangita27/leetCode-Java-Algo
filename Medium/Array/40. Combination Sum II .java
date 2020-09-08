/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
*/

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        if(candidates.length == 0)
            return result;
        Arrays.sort(candidates);
        generate(candidates, new ArrayList<Integer>(), target, 0);
        return result;
    }
    private void generate(int[] nums, ArrayList<Integer> ans, int target, int ind )
    {
        if(target <0)
            return;
        if(target == 0)
        {
            result.add(new ArrayList<>(ans));
            return;
        }
        for(int i = ind; i < nums.length; i++)
        {
            if(i != ind && nums[i-1] == nums[i])
                continue;
            ans.add(nums[i]);
            generate(nums, ans, target- nums[i], i+1);
            ans.remove(ans.size()-1);
        }
    }
}
