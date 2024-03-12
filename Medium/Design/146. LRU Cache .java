/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

*/

class LRUCache {
    int size;
    HashMap<Integer, Integer> map;
    Queue<Integer> q;
    int itemCount ;
    public LRUCache(int capacity) {
        this.size = capacity;
        map = new HashMap<Integer, Integer>();
        q = new LinkedList<Integer>();
        this.itemCount = 0;
    }
    
    public int get(int key) {
        int val = -1;
        if(map.containsKey(key))
        {
            val = map.get(key);
            q.remove(key);
            q.add(key);
        }
        return val;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key))
        {
            if(q.size() == size)
            {
                int index = q.remove();
                map.remove(index);
            }
        }
        else
            q.remove(key);
        map.put(key, value);
        q.add(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


/********************LinkedList Implementation***************************/
class LRUCache {
    HashMap<Integer, Node> map;
    int maxCapacity;
    Node queue;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        map = new HashMap<>();
        queue = new Node(0, 0);
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.right = tail;
        tail.left = head;

    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node item = map.get(key);
        remove(item);
        add(item);
        return item.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node item = map.get(key);
            item.value = value;
            remove(item);
            add(item);
        }
        else
        {
            Node item1 = new Node(key, value);
            if(map.size() == maxCapacity)
            {
                Node itemToBeRemoved = head.right;
                remove(itemToBeRemoved);
                map.remove(itemToBeRemoved.key);
            }
            map.put(key, item1);
            add(item1);
            
        }

    }
    private void remove(Node item)
    {
        item.left.right = item.right;
        item.right.left = item.left;
    }
    private void add(Node item)
    {
        Node prevNode = tail.left;
        prevNode.right = item;
        item.left = prevNode;
        item.right = tail;
        tail.left = item;
    }
}

class Node
{
    int value;
    int key;
    Node left;
    Node right;
    Node(int key, int value)
    {
        this.value = value;
        left = right = null;
        this.key = key;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
