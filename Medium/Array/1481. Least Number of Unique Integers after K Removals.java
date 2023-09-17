/*
Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.

 

Example 1:

Input: arr = [5,5,4], k = 1
Output: 1
Explanation: Remove the single 4, only 5 is left.
Example 2:
Input: arr = [4,3,1,1,3,3,2], k = 3
Output: 2
Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 

Constraints:

1 <= arr.length <= 10^5
1 <= arr[i] <= 10^9
0 <= k <= arr.length
*/

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
	if(arr == null || arr.length == 0)
		return 0;
	HashMap<Integer, Integer> map = new HashMap<>();
	for(int n : arr)
	{
		map.put(n, map.getOrDefault(n, 0)+1);
	}
	List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
	Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>()
{
	public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
	{
		return o1.getValue()-o2.getValue();
	}
});
int index = 0;
    while(index < list.size())
    {
        var item = list.get(index);
				if(item.getValue() > k)
					break;
        k = k - item.getValue();
        if(k >= 0)
            index++;
        else  {  
          index++;
					break;
				}
        
    }

int item = list.size()-index;
return list == null ? 0 : item;
}

}
