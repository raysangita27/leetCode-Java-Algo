/*
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.
*/

class Solution {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return "";
        String[] str = new String[len];
        for(int i = 0; i< len; i++)
            str[i] = String.valueOf(nums[i]);
        Arrays.sort(str, new Comparator<String>(){
            public int compare(String a, String b)
            {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });
        if(str[0].equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        for(String n: str)
            sb.append(n);
        return sb.toString();
    }
}
