//Time Complexity: O(n)
//Space Complexity: O(1)

import java.util.*;

public class FlattenListIterator {
    
 // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
       // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();
    
        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();
    
        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
 
public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> l;
    Queue<Integer> queue;
    public NestedIterator(List<NestedInteger> nestedList) {
        l = nestedList;
        queue = new LinkedList<>();
        addToList(l);
    }

    // pushing elements to the queue if the elements is a integer else pushing to the list
    private void addToList(List<NestedInteger> nestedList) {
        if(nestedList.size() == 0 || nestedList == null)
            return;
        for(NestedInteger n : nestedList){
            if(n.isInteger()){
                queue.add(n.getInteger());
            }
            else
                addToList(n.getList());
        }
    }

    // polling the queue element and pushing it to the queue if integer else recursing it back 
    @Override
    public Integer next() {
        return queue.poll();
    }
    //if queue is empty that means list has no elements in that case it return true which means there are no elements in the list
    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}