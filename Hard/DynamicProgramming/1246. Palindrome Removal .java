/*
Given an integer array arr, in one move you can select a palindromic subarray arr[i], arr[i+1], ..., arr[j] where i <= j, and remove that subarray from the given array. Note that after removing a subarray, the elements on the left and on the right of that subarray move to fill the gap left by the removal.

Return the minimum number of moves needed to remove all numbers from the array.

 

Example 1:

Input: arr = [1,2]
Output: 2
Example 2:

Input: arr = [1,3,4,1,5]
Output: 3
Explanation: Remove [4] then remove [1,3,1] then remove [5].
 

Constraints:

1 <= arr.length <= 100
1 <= arr[i] <= 20

*/

public int minimumMoves(int[] A) {
        int N = A.length;
        //  declare dp array and initialize it with 0s
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++)
            for (int j = 0; j <= N; j++)
                dp[i][j] = 0;
        // loop for subarray length we are considering
        for (int len = 1; len <= N; len++) {
            // loop with two variables i and j, denoting starting and ending of subarray
            for (int i = 0, j = len - 1; j < N; i++, j++) {
                // If subarray length is 1, then 1 step will be needed
                if (len == 1)
                    dp[i][j] = 1;
                else {
                    // delete A[i] individually and assign result for subproblem (i+1,j)
                    dp[i][j] = 1 + dp[i + 1][j];
                    // if current and next element are same, choose min from current and subproblem (i+2,j)
                    if (A[i] == A[i + 1])
                        dp[i][j] = Math.min(1 + dp[i + 2][j], dp[i][j]);
                    // loop over all right elements and suppose Kth element is same as A[i] then
                    // choose minimum from current and two subarray after ignoring ith and A[K]
                    for (int K = i + 2; K <= j; K++)
                        if (A[i] == A[K])
                            dp[i][j] = Math.min(dp[i + 1][K - 1] + dp[K + 1][j], dp[i][j]);
                }
            }
        }
        return dp[0][N - 1];
    }
