/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length == 0)
            return result;
        boolean [] visited = new boolean[nums.length] ;
        visited[0] = false;
        generatePermutation(nums ,new ArrayList<Integer>(), visited, result);
        return result;
    }
    void generatePermutation(int[] nums, List<Integer> ans, boolean [] visited, List<List<Integer>> result )
    {
        if(ans.size() == nums.length)
        {
            result.add(ans);
            return;
        }
        for(int i = 0; i<nums.length; i++  ) {
            if(visited[i] == false){
                ans.add(nums[i]);
            visited[i] = true;
            generatePermutation(nums, new ArrayList<>(ans), visited, result);
            visited[i] = false;
            ans.remove(ans.size() -1);
        }
        }
        
    }
}
