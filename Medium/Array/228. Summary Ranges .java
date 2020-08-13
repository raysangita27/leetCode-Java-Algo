/*
Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
*/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        int len = nums.length;
        if(len == 0)
            return result;
        if(len == 1){
            result.add(String.valueOf(nums[0]));    
            return result;
        }
             
        int start = 0;
        int end = 0;
        while(end <len-1)
        {
            if(nums[end+1] - nums[end]== 1|| nums[end+1] == nums[end] )
            {
                end++;
                continue;
            }
            else
            {
                updateList(result, nums[start],nums[end]);
                end++;
                start = end;
            }
        }
        updateList(result, nums[start],nums[end]);
        return result;
    }
    void updateList(List<String> result, int left, int right)
    {
        if(left == right)
        {
            result.add(String.valueOf(left));
            return ;
        }
        else
        {
            result.add(left +"->"+ right);
        }
    }
}
