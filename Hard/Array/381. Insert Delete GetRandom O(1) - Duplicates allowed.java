/*
RandomizedCollection is a data structure that contains a collection of numbers, possibly duplicates (i.e., a multiset). It should support inserting and removing specific elements and also reporting a random element.

Implement the RandomizedCollection class:

RandomizedCollection() Initializes the empty RandomizedCollection object.
bool insert(int val) Inserts an item val into the multiset, even if the item is already present. Returns true if the item is not present, false otherwise.
bool remove(int val) Removes an item val from the multiset if present. Returns true if the item is present, false otherwise. Note that if val has multiple occurrences in the multiset, we only remove one of them.
int getRandom() Returns a random element from the current multiset of elements. The probability of each element being returned is linearly related to the number of the same values the multiset contains.
You must implement the functions of the class such that each function works on average O(1) time complexity.

Note: The test cases are generated such that getRandom will only be called if there is at least one item in the RandomizedCollection.

 

Example 1:

Input
["RandomizedCollection", "insert", "insert", "insert", "getRandom", "remove", "getRandom"]
[[], [1], [1], [2], [], [1], []]
Output
[null, true, false, true, 2, true, 1]

Explanation
RandomizedCollection randomizedCollection = new RandomizedCollection();
randomizedCollection.insert(1);   // return true since the collection does not contain 1.
                                  // Inserts 1 into the collection.
randomizedCollection.insert(1);   // return false since the collection contains 1.
                                  // Inserts another 1 into the collection. Collection now contains [1,1].
randomizedCollection.insert(2);   // return true since the collection does not contain 2.
                                  // Inserts 2 into the collection. Collection now contains [1,1,2].
randomizedCollection.getRandom(); // getRandom should:
                                  // - return 1 with probability 2/3, or
                                  // - return 2 with probability 1/3.
randomizedCollection.remove(1);   // return true since the collection contains 1.
                                  // Removes 1 from the collection. Collection now contains [1,2].
randomizedCollection.getRandom(); // getRandom should return 1 or 2, both equally likely.
 

Constraints:

-231 <= val <= 231 - 1
At most 2 * 105 calls in total will be made to insert, remove, and getRandom.
There will be at least one element in the data structure when getRandom is called.

*/

class RandomizedCollection {
    List<Integer> list;
    Random rand;
    HashMap<Integer, List<Integer>> map;
    public RandomizedCollection() {
        rand = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        //boolean found = map.containsKey(val);
        if(!map.containsKey(val))
        {
            map.put(val, new ArrayList<>());
                    map.get(val).add(list.size());
        list.add(val);
            return true;
           
        }
        map.get(val).add(list.size());
        list.add(val);
        return false;
        
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val) || map.get(val).size() == 0)
            return false;
        List<Integer> target = map.get(val);
        int lastItem = list.get(list.size()-1); // find last item that will be swapped.
        int targetIndex = target.get(target.size()-1); // find index that should be replace with last item
        map.get(val).remove(target.size()-1);// remove target index from map
        list.set(targetIndex, lastItem); // swap last item with targetted index.
        map.get(lastItem).add(targetIndex); // add taregtindex in map for lastitem list
        map.get(lastItem).remove(Integer.valueOf(list.size()-1)); // remove the lastindex from lastitem list.
        list.remove(list.size()-1); // remove list last item
        if(map.get(val).size() == 0)
            map.remove(val);
        return true;
            
    }
 
    
    public int getRandom() {
        int index = rand.nextInt(list.size());
        return list.get(index);    
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
