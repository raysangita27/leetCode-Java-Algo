/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length == 0)
            return result;
        result.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++)
        {
            int size = result.size();
            for(int j = 0; j<size; j++)
            {
                var list = new ArrayList<>(result.get(j));
                list.add(nums[i]);
            
                if(!result.contains(list))
                    result.add(list);
            }
        }
        return result;
    }
}
