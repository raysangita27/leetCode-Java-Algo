/*
You are given a char array representing tasks CPU need to do. It contains capital letters A to Z where each letter represents a different task. Tasks could be done without the original order of the array. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

You need to return the least number of units of times that the CPU will take to finish all the given tasks.

 

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
Example 2:

Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.
Example 3:

Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation: 
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
 

Constraints:

The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        if(len == 0)
            return 0;
        int[] count = new int[26];
        int max = 0;
        // check the maximum occurance of A task in the array
        for(int i = 0; i<len; i++)
        {
            count[tasks[i] - 'A']++;
            max = Math.max(max, count[tasks[i] - 'A']);
        }
        // check the number of tasks which have maximumcount 
        int maxOccuringTask = 0;
        for(int i = 0; i< 26; i++)
        {
            if(count[i] == max)
                maxOccuringTask ++;
        }
        System.out.println(max + " " + maxOccuringTask);
       /* The key idea is that the interval is bounded by the tasks with most appearances. We need to fill the idles with other tasks. However, in fact we do not need to care about the other tasks. If all the idles are filled, means the lengths is tasks.length is the result, if the idles are not filled, we only need to know the task with most count (max), then get the window size (n+1), add the number of tasks with most count.
       */
        return Math.max(len, ((n + 1) *(max-1)) + maxOccuringTask);
    }
}
