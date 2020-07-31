/*
On a single threaded CPU, we execute some functions.  Each function has a unique id between 0 and N-1.

We store logs in timestamp order that describe when a function is entered or exited.

Each log is a string with this format: "{function_id}:{"start" | "end"}:{timestamp}".  For example, "0:start:3" means the function with id 0 started at the beginning of timestamp 3.  "1:end:2" means the function with id 1 ended at the end of timestamp 2.

A function's exclusive time is the number of units of time spent in this function.  Note that this does not include any recursive calls to child functions.

The CPU is single threaded which means that only one function is being executed at a given time unit.

Return the exclusive time of each function, sorted by their function id.

 

![Example](https://github.com/raysangita27/leetCode-Java-Algo/blob/master/images/exclusiveTimeInterval.png)



Input:
n = 2
logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
Output: [3, 4]
Explanation:
Function 0 starts at the beginning of time 0, then it executes 2 units of time and reaches the end of time 1.
Now function 1 starts at the beginning of time 2, executes 4 units of time and ends at time 5.
Function 0 is running again at the beginning of time 6, and also ends at the end of time 6, thus executing for 1 unit of time. 
So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.
 

Note:

1 <= n <= 100
Two functions won't start or end at the same time.
Functions will always log when they exit.
 1. Create a stack of pair ( function id : Timestamp) .
          2. If you encountered "start" push the the pair Object  in stack .
          3. Else pop the value from stack calculate  calculatedTs = current time stamp - pop timetsmap +1  for this function and add it to response array ;
             3.1 if stack has more elemnts then update the time stamp of stack top element in responseArray  by -calculatedTs.
             
             // Dry run of above algorithm
             int res =int[2];
             logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
               i=0  stack.push --> 0 =0
               i=1  stack.push --> 1 =2
               i=2   ts =  current - stack.pop() +1 --> 5 - 2 +1 = 4 
                     res[1] += ts= 4;
                     res[0] += -ts = -4;
               i=3   ts =  current - stack.pop() +1 --> 6 - 0 +1 = 7
                     res[0]+=7 = -4+7 =3;
 */
 
 class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(n == 0)
            return new int[]{};
        int[] result = new int[n];
        Stack<Pair<Integer,Integer>> stk = new Stack<>();
        for(var log : logs)
        {
            String[] content = log.split(":");
            int funcId = Integer.parseInt(content[0]);
            int time = Integer.parseInt(content[2]);
            if(content[1].equals("start"))
            {
                Pair<Integer,Integer> startDetails = new Pair(funcId , time );
                stk.push(startDetails);
            }
            else
            {
                int timeCount =  time - stk.pop().getValue() +1;
                result[funcId] += timeCount;
                if(!stk.isEmpty())
                    result[stk.peek().getKey()] -= timeCount;
            }
        }
        return result;
    }
}
 
