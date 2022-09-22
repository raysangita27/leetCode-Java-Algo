/*
You have information about n different recipes. You are given a string array recipes and a 2D string array ingredients. The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients from ingredients[i]. Ingredients to a recipe may need to be created from other recipes, i.e., ingredients[i] may contain a string that is in recipes.

You are also given a string array supplies containing all the ingredients that you initially have, and you have an infinite supply of all of them.

Return a list of all the recipes that you can create. You may return the answer in any order.

Note that two recipes may contain each other in their ingredients.

 

Example 1:

Input: recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast","flour","corn"]
Output: ["bread"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
Example 2:

Input: recipes = ["bread","sandwich"], ingredients = [["yeast","flour"],["bread","meat"]], supplies = ["yeast","flour","meat"]
Output: ["bread","sandwich"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
Example 3:

Input: recipes = ["bread","sandwich","burger"], ingredients = [["yeast","flour"],["bread","meat"],["sandwich","meat","bread"]], supplies = ["yeast","flour","meat"]
Output: ["bread","sandwich","burger"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
We can create "burger" since we have the ingredient "meat" and can create the ingredients "bread" and "sandwich".
 

Constraints:

n == recipes.length == ingredients.length
1 <= n <= 100
1 <= ingredients[i].length, supplies.length <= 100
1 <= recipes[i].length, ingredients[i][j].length, supplies[k].length <= 10
recipes[i], ingredients[i][j], and supplies[k] consist only of lowercase English letters.
All the values of recipes and supplies combined are unique.
Each ingredients[i] does not contain any duplicate values.

*/
class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new ArrayList<>();
        if(recipes == null || recipes.length == 0)
            return result;
        int len = recipes.length;
        HashMap<String,Set<String>> map = new HashMap<>();
        HashMap<String, Integer> indegree = new HashMap<>();
        for(int i = 0; i < len; i++)
        {
            var ing = ingredients.get(i);
           indegree.put(recipes[i], ing.size());
            for(String item : ing)
            {
                if(!map.containsKey(item))
                    map.put(item, new HashSet());
                map.get(item).add(recipes[i]);
            }
        }
        Queue<String> q = new LinkedList<>();
        for(String sup : supplies)
            q.add(sup);
        while(!q.isEmpty())
        {
            var cur = q.remove();
            if(map.containsKey(cur)){
                for(String rec : map.get(cur))
                {
                    
                    indegree.put(rec, indegree.get(rec)-1);
                    if(indegree.get(rec) == 0)
                    {
                        q.add(rec);
                        result.add(rec);
                    }
                }
                map.remove(cur);
            }
        }
        return result;
    }
}
