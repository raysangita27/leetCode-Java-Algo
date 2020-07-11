/*
There are n people whose IDs go from 0 to n - 1 and each person belongs exactly to one group. Given the array groupSizes of length n telling the group size each person belongs to, return the groups there are and the people's IDs each group includes.

You can return any solution in any order and the same applies for IDs. Also, it is guaranteed that there exists at least one solution. 

 

Example 1:

Input: groupSizes = [3,3,3,3,3,1,3]
Output: [[5],[0,1,2],[3,4,6]]
Explanation: 
Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
Example 2:

Input: groupSizes = [2,1,3,3,3,2]
Output: [[1],[0,5],[2,3,4]]
 

Constraints:

groupSizes.length == n
1 <= n <= 500
1 <= groupSizes[i] <= n
*/

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = groupSizes.length;
        HashMap<Integer, List<Integer>> map = new HashMap<Integer,  List<Integer>>();
        for(int i = 0; i<len; i++ )
        {
            if(!map.containsKey(groupSizes[i]) )
            {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                map.put(groupSizes[i], temp);
            }
            else
            {
                var list = map.get(groupSizes[i]);
                list.add(i);
                map.put(groupSizes[i], list);
            }
            
        }
        for(var key : map.keySet() )
        {
            
            
            var list = map.get(key);
            int size = list.size();
            int i = size-1;
            while( i>=0)
            {
                List<Integer> temp = new ArrayList<Integer>();
                result.add(list.subList(i-key+1,i+1) );
                i = i-key;
                  
            }
            
            
           
        }
        return result;
    }
}
