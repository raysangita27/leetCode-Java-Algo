/*
Given an integer n, return any array containing n unique integers such that they add up to 0.

 

Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
Example 2:

Input: n = 3
Output: [-1,0,1]
Example 3:

Input: n = 1
Output: [0]
 

Constraints:

1 <= n <= 1000
*/

class Solution {
    public int[] sumZero(int n){
        if(n == 0 || n == 1)
            return new int[]{0};
        int[] result = new int[n];
        int digit = -1 * n/2;
        int count = 0;
        while(count < n)
        {
            
            if(n%2 == 0 && digit == 0)
            {
                digit++;
                continue;
            }
                
            result[count++] =  digit;
            digit++;
        }
        return result;    
                
    }
}

public class MainClass {
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            
            int[] ret = new Solution().sumZero(n);
            
            String out = integerArrayToString(ret);
            
            System.out.print(out);
        }
    }
}
