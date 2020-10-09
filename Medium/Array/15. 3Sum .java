/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums){ {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length == 0 || nums == null)
            return result;
        Arrays.sort(nums);
        for(int i = 0; i< nums.length-2; i++)
        {
          //check if 2 numbers are same , skip processing
            if(i > 0 && nums[i] == nums[i-1])
              continue;
            int j = i+1;
            int k = nums.length -1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0)
                {
                    List<Integer> temp =  new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                        result.add(temp);
                    j++;
                    k--;
                    //check if 2 numbers are same , skip the number to make the list uniue
                    while(j < k && nums[j] == nums[j-1])
                        j++;
                    while(j < k && nums[k] == nums[k+1])
                        k--;
                }
                else if(sum > 0)
                    k--;
                else
                    j++;
            }
        }
        return result;
            
    }}
}
/*
Time Complexity : O(n^2)
Sorting time : O(nlogn)
TimeComplexity : O(n2)
 */
/*
Space Complexity: from O(logn) to O(n), depending on the implementation of the sorting algorithm. For the purpose of complexity analysis, we ignore the memory required for the output.
*/
