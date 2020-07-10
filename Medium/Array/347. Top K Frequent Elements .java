/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length  == 0)
            return nums;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : nums)
        {
            if(map.containsKey(a) )
                map.put(a, map.get(a)+1 );
            else
                map.put(a, 1);
        }
        List<Map.Entry<Integer,Integer>> list = new  ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>(){
            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2){
                if(o1.getValue() == o2.getValue())
                    return o2.getKey() - o2.getKey();
                else 
                    return o2.getValue() - o1.getValue();
            }
        } );
        
        int i = 0;
        int[] result = new int[k];
        for(var l : list)
        {
            if(i == k)
                break;
            result[i++] = l.getKey();
            
        }
        return result;
    }
}
