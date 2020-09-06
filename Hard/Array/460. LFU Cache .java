/*
Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.

 

Follow up:
Could you do both operations in O(1) time complexity?

 

Example:

LFUCache cache = new LFUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.get(3);       // returns 3.
cache.put(4, 4);    // evicts key 1.
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/

class LFUCache {
    HashMap<Integer, Node> cacheMap;
    HashMap<Integer, LinkedHashSet<Node>> freqMap;
    int minFreq;
    int capacity;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 0;
        cacheMap = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!cacheMap.containsKey(key))
            return -1;
        Node temp = cacheMap.get(key);
        update(temp);
        return temp.value;
    }
    
    private void update(Node node)
    {
        LinkedHashSet<Node> prevfreqNodeSet = freqMap.get(node.freq);
        prevfreqNodeSet.remove(node);
        if(prevfreqNodeSet.size() == 0 && node.freq == minFreq)
            minFreq++;
        node.freq++;
        if(!freqMap.containsKey(node.freq))
            freqMap.put(node.freq, new LinkedHashSet<Node>());
        freqMap.get(node.freq).add(node);
    }
    
    public void put(int key, int value) {
        if(capacity <= 0)
            return;
        if(cacheMap.containsKey(key))
        {
            Node node = cacheMap.get(key);
            update(node);
            node.value = value;
        }
        else
        {
            Node node = new Node(key, value, 1);
            cacheMap.put(key, node);
            if(!freqMap.containsKey(1))
                freqMap.put(1, new LinkedHashSet<Node>());
            freqMap.get(1).add(node);
            if(cacheMap.size()> capacity)
            {
                var  linkedSet = freqMap.get(minFreq);
                Node tobeRemove = linkedSet.iterator().next();
                linkedSet.remove(tobeRemove);
                cacheMap.remove(tobeRemove.key);
            }
            minFreq = 1;
            
        }
    }
}
public class Node{
    int key;
    int value;
    int freq;
    public Node(int key, int value, int freq)
    {
        this.key = key;
        this.value = value;
        this.freq = freq;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
