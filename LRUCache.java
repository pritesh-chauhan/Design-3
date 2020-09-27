//Time Complexity: O(n) get: O(n) put: O(1)
//Space Complexity: O(n)

import java.util.*;

class LRUCache {

    Map<Integer, Integer> map = new HashMap<>();
    Queue<Integer> queue = new LinkedList<>();
    int max_size;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        max_size = capacity;
    }
    
    // if key is not present in the map return -1 else remove queue element and add key to the queue and return map
    // queue is used to maintain the sequencing
    public int get(int key) {
        if (!map.containsKey(key)) 
            return -1;
        queue.remove(key);
        queue.add(key);
        return map.get(key);
    }
    
    // if the map is full of capacity and key is not present the start removing map elements 
    // if the map has key update the priority by removing and then adding towards the end of the queue and updating maps value
    public void put(int key, int value) {
        if (!map.containsKey(key) && map.size() == max_size)                    
            map.remove(queue.remove());
        if (map.containsKey(key)) 
            queue.remove(key);  
        map.put(key, value);
        queue.add(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */