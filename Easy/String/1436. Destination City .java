/*
You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.

It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.

 

Example 1:

Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
Output: "Sao Paulo" 
Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
Example 2:

Input: paths = [["B","C"],["D","B"],["C","A"]]
Output: "A"
Explanation: All possible trips are: 
"D" -> "B" -> "C" -> "A". 
"B" -> "C" -> "A". 
"C" -> "A". 
"A". 
Clearly the destination city is "A".
Example 3:

Input: paths = [["A","Z"]]
Output: "Z"
 

Constraints:

1 <= paths.length <= 100
paths[i].length == 2
1 <= cityAi.length, cityBi.length <= 10
cityAi != cityBi
All strings consist of lowercase and uppercase English letters and the space character.
*/

class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = paths.size();
        if(n ==1)
            return paths.get(0).get(1);
        for(int i = 0; i<n; i++)
        {
            var pathSet = paths.get(i);
            //if a source city is avaiable, increase the value by 1
            if(map.containsKey(pathSet.get(0)))
                map.put(pathSet.get(0) ,map.get(pathSet.get(0))+1);
            //if a destination city is avaiable, decrease the value by 1
            else if(!map.containsKey(pathSet.get(0)))
                 map.put(pathSet.get(0) ,1);
            if(map.containsKey(pathSet.get(1)))
                map.put(pathSet.get(1) ,map.get(pathSet.get(1))-1);
            else if(!map.containsKey(pathSet.get(1)))
                 map.put(pathSet.get(1) ,-1);
                
           
            
        }
        for(var key : map.keySet())
        {
            //for only destination city value should be negative
             if(map.get(key) <0)
                return key;
        }  
        return null;
    }
}
