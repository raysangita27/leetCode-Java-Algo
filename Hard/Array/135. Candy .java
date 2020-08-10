/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.
             */
             
class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        if(len == 0)
            return 0;
        int[] candy = new int[len];
        Arrays.fill(candy,1);
            // traverse from left to check the neighbour rating and add one extra candy to that
        for(int i = 0; i<len-1; i++)
        {
            if(ratings[i] < ratings[i+1])
                candy[i+1] = candy[i] +1;
        }
        //traverse from right to check neighbour rating and if neighbour candy is less add 1 to that
        for(int i = len-1; i>0; i--)
        {
            if(ratings[i-1] > ratings[i] && candy[i-1] < candy[i]+1)
                candy[i-1] = candy[i] +1;
        }
        int totalCandy = 0;
        for(int i = 0; i<len; i++)
            totalCandy += candy[i];
        return totalCandy;
    }
}

*/ Explanation */
/*
We take ratings array as [5, 6, 2, 2, 4, 8, 9, 5, 4, 0, 5, 1]
In the given problem each student will have at least 1 candy. So distribute 1 candy to each.

ratings:     [5, 6, 2, 2, 4, 8, 9, 5, 4, 0, 5, 1]
candies:     [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
Now traverse the array from left to right. If the rating of (n+1) child is greater than (n) child then set the candy of (n+1) child as one candy more than the (n) child candies.

ratings:     [5, 6, 2, 2, 4, 8, 9, 5, 4, 0, 5, 1]
candies:     [1, 2, 1, 1, 2, 3, 4, 1, 1, 1, 2, 1]
Now traverse the array from right to left. If the (n) child rating is more than (n+1) child and (n) child candies is less than one more than (n+1) child candies then update the candies of (n) child as 1+ (n+1) candies.

ratings:     [5, 6, 2, 2, 4, 8, 9, 5, 4, 0, 5, 1]
candies:     [1, 2, 1, 1, 2, 3, 4, 3, 2, 1, 2, 1]
Total minimum candies: 23
*/
