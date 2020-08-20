/*
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
         Arrays.sort(nums);
        List<List<Integer>> sol = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            
            for (int l = i + 1; l < nums.length - 2; l++) {
                if (l - 1 != i && nums[l] == nums[l - 1])
                    continue;
                
                int j = l + 1;
                int k = nums.length - 1;
                
                while (j < k) {
                    if (nums[i] + nums[l] + nums[j] + nums[k] == target) {
                        sol.add(Arrays.asList(nums[i], nums[l], nums[j], nums[k]));
                        // advance them both one -- keep in mind if you only advanced one, you could get a repeat!
                        j++;
                        k--;
                        while(j < k && nums[j - 1] == nums[j])
                            j++;
                        while(j < k && nums[k + 1] == nums[k])
                            k--;
                    } else if (nums[i] + nums[l] + nums[j] + nums[k] < target) {
                        j++;
                    } else if (nums[i] + nums[l] + nums[j] + nums[k] > target) {
                        k--;
                    }
                }
            }
        }
        
        return sol;
    }
}
