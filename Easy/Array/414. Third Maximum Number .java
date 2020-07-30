/*
Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
*/

class Solution {
    public int thirdMax(int[] nums) {
       long max1 = Long.MIN_VALUE, max2 = max1, max3 = max1;
	    int count = 0;
	    for (int i=0; i<nums.length; i++) {
		if (nums[i] > max1) {
			max3 = max2;
			max2 = max1;
			max1 = nums[i];
		} else if (nums[i] > max2 && nums[i] != max1) {
			max3 = max2;
			max2 = nums[i];
		} else if (nums[i] >= max3 && nums[i] != max2 && nums[i] != max1) {
			max3 = nums[i];
		}
	}
	return (int)(max3 < Integer.MIN_VALUE ? max1 : max3);
    }
}
