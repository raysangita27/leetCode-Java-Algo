/*
Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);
*/

class Solution {

    HashMap<Integer, List<Integer>> map ;
    public Solution(int[] nums) {
        map = new  HashMap<Integer,List<Integer>>();
        for(int i = 0; i <nums.length; i++)
        {
            if(map.containsKey(nums[i]) )
            {
                var list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i], list);
            }
            else
            {
                var list = new ArrayList<Integer>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
    }
    
    public int pick(int target) {
        var list= map.get(target);
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
