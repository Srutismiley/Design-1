// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Created an double array of capacity 1000 and 1000
// in  case of collision - we can use double hashing, linear probing or linear chaining
// used double hashing in the below example
// if add an element then set it as true
//if remove an element then set it as false
// if bucket is 0 we need to add 1001 elements - otherwise we get arrayIndexOutofbounds exception as we 
// index only till 999

class MyHashSet {

    boolean[][]  storage ;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    
    }

    private int hash1(int key){
        return key%1000;
    }

    private int hash2(int key){
        return key/1000;
    }
    
    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null){
            if(bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            }else { 
                storage[bucket] = new boolean[bucketItems];
            }    
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null){
            return;
        } 
        storage[bucket][bucketItem] = false;  
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null){
            return false;
        }   
        return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */