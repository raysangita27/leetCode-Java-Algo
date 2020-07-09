/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
*/

class Solution {
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        Stack<Integer> stk = new Stack<Integer>();
        
        for(int i = 0; i<len; i++)
        {
            String c = tokens[i];
            
            if(c.equals("+") ||c.equals("-") ||c.equals("*") || c.equals("/")) 
            {
    
                int b = stk.pop();
                int a = stk.pop();
                switch (c){
                    case "/":   int temp = a/b;
                                stk.push(temp);
                                break;
                    case "*": stk.push(a*b);
                                break;
                    case "+": stk.push(a+b);
                                break;
                    case "-": stk.push(a-b);
                                break;
                        
                }
            }
            else
                stk.push(Integer.parseInt(c));
        }
        return stk.peek();
    }
}

public class MainClass {
    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
          arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] tokens = stringToStringArray(line);
            
            int ret = new Solution().evalRPN(tokens);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}
