/*
Given a string IP, return "IPv4" if IP is a valid IPv4 address, "IPv6" if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type.

A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 and xi cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0" are valid IPv4 addresses but "192.168.01.1", while "192.168.1.00" and "192.168@1.1" are invalid IPv4 addresses.

A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:

1 <= xi.length <= 4
xi is a hexadecimal string which may contain digits, lower-case English letter ('a' to 'f') and upper-case English letters ('A' to 'F').
Leading zeros are allowed in xi.
For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0:8A2E:0370:7334" are valid IPv6 addresses, while "2001:0db8:85a3::8A2E:037j:7334" and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.

 

Example 1:

Input: IP = "172.16.254.1"
Output: "IPv4"
Explanation: This is a valid IPv4 address, return "IPv4".
Example 2:

Input: IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
Output: "IPv6"
Explanation: This is a valid IPv6 address, return "IPv6".
Example 3:

Input: IP = "256.256.256.256"
Output: "Neither"
Explanation: This is neither a IPv4 address nor a IPv6 address.
Example 4:

Input: IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:"
Output: "Neither"
Example 5:

Input: IP = "1e1.4.5.6"
Output: "Neither"
 

Constraints:

IP consists only of English letters, digits and the characters '.' and ':'.
*/

class Solution {
    public String validIPAddress(String IP) {
        if(isValidIPV4(IP))
            return "IPv4";
        else if(isValidIPV6(IP))
            return "IPv6";
        else
            return "Neither";
    }
    private boolean isValidIPV4(String ip)
    {
        if(ip.length()< 7)
            return false;
        if(ip.charAt(0) == '.')
            return false;
        if(ip.charAt(ip.length()-1)== '.')
            return false;
        String[] tokens = ip.split("\\.");
        if(tokens.length != 4)
            return false;
        for(String token : tokens)
        {
            if(!isValidIPv4Token(token))
                return false;
        }
        return true;
        
    }
    private boolean isValidIPv4Token(String token)
    {
        if(token.startsWith("0") && token.length()>1)
            return false;
        try{
            int parsedInt = Integer.parseInt(token);
            if(parsedInt < 0 || parsedInt > 255)
                return false;
            else if(parsedInt == 0 && token.charAt(0) != '0')
                return false;
        }
        catch(NumberFormatException  nfe)
        {
            return false;
        }
        return true;
    }
    private boolean isValidIPv6Token(String token)
    {
        
        if(token.length()>4 || token.length()==0)
            return false;
        char[] chars = token.toCharArray();
        for(char c : chars)
        {
            boolean isDigit = (c >= 48 && c<=57);
            boolean isAF = (c >=65 && c<=70);
            boolean isLowerAF = (c >=97 && c<=102);
            if(!(isDigit || isAF || isLowerAF))
                return false;
        }
        return true;
        
    }
    private boolean isValidIPV6(String ip)
    {
        if(ip.length()< 15)
            return false;
         if(ip.charAt(0) == ':')
            return false;
        if(ip.charAt(ip.length()-1)== ':')
            return false;
        String[] tokens = ip.split("\\:");
        if(tokens.length != 8)
            return false;
        for(String token : tokens)
        {
            if(!isValidIPv6Token(token))
                return false;
        }
        return true;
        
        
    }
}
