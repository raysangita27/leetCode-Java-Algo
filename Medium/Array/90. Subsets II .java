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

/*************using backtrack*******************/

class Solution {
    int i ;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        Arrays.sort(nums);
        for( i = 0; i <= nums.length; i++)
        {
            
            backtrack(nums, 0, new ArrayList<Integer>(), result);
        }   
        return result;
    }
    public void backtrack(int[] nums, int index, List<Integer> ans, List<List<Integer>> result)
    {
        if(ans.size() == i)
        {
            //if(!result.contains(ans))
            result.add(new ArrayList<>(ans));
            return ;
        }
        for(int j = index; j < nums.length; j++)
        {
            if(j != index && nums[j] == nums[j-1])
                continue;

            ans.add(nums[j]);
            backtrack(nums, j+1, ans, result);
            ans.remove(ans.size()-1);

        }

    }
}

//TC : (n * 2^n)
