/*
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10

*/

class Solution {
    List<List<Integer>> result;
public List<List<Integer>> subsetsWithDup(int[] nums) {
    result = new ArrayList<List<Integer>>();
    if(nums == null || nums.length == 0)
        return result;
    Arrays.sort(nums);
        checkSet(nums, 0, new ArrayList<Integer>());
    return result;
}

public void checkSet(int[] nums, int ind, ArrayList<Integer> ans)
{
    result.add(new ArrayList<Integer>(ans));
    for(int i = ind; i < nums.length; i++)
    {
        if(i > ind && nums[i] == nums[i-1])
            continue;
        ans.add(nums[i]);
        checkSet(nums, i+1, ans);
        ans.remove(ans.size()-1);
    }
}
}
