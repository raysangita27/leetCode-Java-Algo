/*
There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the buildings in the line.

The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.

Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.

 

Example 1:

Input: heights = [4,2,3,1]
Output: [0,2,3]
Explanation: Building 1 (0-indexed) does not have an ocean view because building 2 is taller.
Example 2:

Input: heights = [4,3,2,1]
Output: [0,1,2,3]
Explanation: All the buildings have an ocean view.
Example 3:

Input: heights = [1,3,2,4]
Output: [3]
Explanation: Only building 3 has an ocean view.
 

Constraints:

1 <= heights.length <= 105
1 <= heights[i] <= 109

*/

class Solution {
    public int[] findBuildings(int[] heights) {
        if(heights == null || heights.length == 0)
            return heights;
        LinkedList<Integer> result = new LinkedList<Integer>();
        
        for(int i = 0; i < heights.length ; i++)
        {
            while(result.size() > 0 && heights[result.get(result.size()-1)] <= heights[i])
            {
                result.remove(result.size()-1);
            }
            result.add(i);
        }
        int[] ans = new int[result.size()];
        int j = 0;
        for(int x : result)
            ans[j++] = x;
        return ans;
    }
}
/*
Complexity Analysis

Here NN is the size of the given array.

Time complexity: O(N)O(N).

We iterate over the given array once.
Each building's index can be pushed to answer and popped from answer at most once, and both of the operations take O(1)O(1) time.
In Java, copying the elements from an array list to an integer array will take an additional O(N)O(N) time.
Space complexity: O(N)O(N).

There is no auxiliary space used other than the output. The output does not count towards the space complexity. However, in the worst-case scenario, answer may contain as many as N - 1N−1 indices, and then the very last building is the tallest, so the output will reduce to one index. In this scenario, the algorithm must store N - 1N−1 elements at some point, but only 11 element is included in the output.
In Java, in order to maintain a dynamic size array, we created an extra Array List that supports fast O(1)O(1) push/pop operation. Array List can contain at most NN elements. Hence in Java, an additional O(N)O(N) space is used.
*/
