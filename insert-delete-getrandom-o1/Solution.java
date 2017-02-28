public class RandomizedSet {
    private int[] data;
    private int size;
    private int capacity;
    
    private HashMap<Integer, Integer> lookup;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        size = 0;
        capacity = 11;
        data = new int[capacity];
        
        lookup = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (lookup.get(val) != null) {
            return false;
        }
        
        if (size == capacity) {
            capacity *= 2;
            int[] newData = new int[capacity];
            
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            
            data = newData;
        }
        
        data[size] = val;
        lookup.put(val, size);
        size++;
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer index = lookup.get(val);
        if (index == null) {
            return false;
        }
        
        if (index != size - 1) {
            int last = data[size - 1];
            data[index] = last;
            lookup.put(last, index);
        }
        
        lookup.remove(val);
        size--;
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return data[(int)(Math.random() * size)];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
