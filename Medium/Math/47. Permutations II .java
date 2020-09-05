/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

class Solution {
    List<List<Integer>>  result;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<List<Integer>>();
        if(nums== null || nums.length == 0)
            return result;
        boolean[] visited= new boolean[nums.length];
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        helper(nums, visited,list);
        return result;
    }
    private void helper(int[] nums, boolean[] visited,List<Integer> list )
    {
        if(list.size() == nums.length)
        {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i<nums.length; i++)
        {
            if(visited[i])
                continue;
            if(i > 0 && nums[i-1] == nums[i] && visited[i-1]== true)
                continue;
            list.add(nums[i]);
            visited[i] = true;
            helper(nums, visited, list);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
}
