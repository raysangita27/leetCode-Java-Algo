/*
Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

Example:

Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]
*/

class Solution {
     List<String> result ;
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        result = new ArrayList<String>();
        int len = nums.length;
        if(len == 0)
        {
           updateList(lower, upper);
            return result;
        }
        
        if(lower != nums[0])
            updateList(lower, nums[0]-1);
                
        for(int i = 0; i< len-1; i++)
        {
            if(nums[i+1] - nums[i] == 1 || nums[i+1] == nums[i])
                continue;
            updateList(nums[i] +1, nums[i+1]-1);
        }
        
        if(upper != nums[len-1])
            updateList(nums[len-1] +1, upper);
        return result;
        
    }
    void updateList(int left, int right)
    {
        if(left == right)
        {
            result.add(String.valueOf(left));
            return;
        }
        else
            result.add(left + "->" + right);
    }
}
