/*
In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.

Return the element repeated N times.

 

Example 1:

Input: [1,2,3,3]
Output: 3
Example 2:

Input: [2,1,2,5,3,2]
Output: 2
Example 3:

Input: [5,1,5,2,5,3,5,4]
Output: 5
 

Note:

4 <= A.length <= 10000
0 <= A[i] < 10000
A.length is even
*/
class Solution {
    public int repeatedNTimes(int[] A) {
        int len = A.length;
        if(len == 0)
            return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<len; i++)
        {
            if(map.containsKey(A[i]) )
            {
                int count = map.get(A[i]) +1;
                if(count == len/2)
                    return A[i];
                else
                    map.put(A[i], count);
            }
            else
                 map.put(A[i], 1);
        }
        return -1;
    }
}
