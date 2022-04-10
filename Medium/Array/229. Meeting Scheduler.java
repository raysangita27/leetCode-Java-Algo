
/*
Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.

If there is no common time slot that satisfies the requirements, return an empty array.

The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.

It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.

 

Example 1:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
Output: [60,68]
Example 2:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
Output: []
 

Constraints:

1 <= slots1.length, slots2.length <= 104
slots1[i].length, slots2[i].length == 2
slots1[i][0] < slots1[i][1]
slots2[i][0] < slots2[i][1]
0 <= slots1[i][j], slots2[i][j] <= 109
1 <= duration <= 106
*/


class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
	ArrayList<Integer> result = new ArrayList<Integer>();
    Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
    Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
	int ind1 = 0;
	int ind2 = 0;
	while(ind1 < slots1.length && ind2 < slots2.length)
	{
		int start = Math.max(slots1[ind1][0], slots2[ind2][0]);
		int end = Math.min(slots1[ind1][1], slots2[ind2][1]);
		if(start < end && end -start >= duration)
			return new ArrayList<Integer>(Arrays.asList(start, start + duration));
		if(slots1[ind1][1] < slots2[ind2][1])
			ind1++;
		else 
			ind2++;
	}
	return result;
}

}


/*
Complexity Analysis

Time complexity: O(M \log M + N \log N)O(MlogM+NlogN), when MM is the length of slots1 and NN is the length of slots2.

Sorting both arrays would take O(M \log M + N \log N)O(MlogM+NlogN). The two pointers take O(M + N)O(M+N) because, during each iteration, we would visit a new element, and there are a total of M+NM+N elements. Putting these together, the total time complexity is O(M \log M + N \log N)O(MlogM+NlogN).

Space complexity: O(1)O(1). This is because we do not use any additional data structures; we only use a few fixed-size integer variables.
*/
