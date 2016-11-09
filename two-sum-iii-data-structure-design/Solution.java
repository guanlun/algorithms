public class TwoSum {
    private HashMap<Integer, Integer> lookup = new HashMap<Integer, Integer>();

    // Add the number to an internal data structure.
	public void add(int number) {
	    Integer count = lookup.get(number);

	    if (count == null) {
	        lookup.put(number, 1);
	    } else {
	        lookup.put(number, count + 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (HashMap.Entry<Integer, Integer> entry : lookup.entrySet()) {
	        int num = entry.getKey();
	        int rem = value - entry.getKey();

	        if (num == rem) {
	            if (entry.getValue() >= 2) {
	                return true;
	            } else {
	                continue;
	            }
	        }

	        Integer remCount = lookup.get(rem);

	        if (remCount != null) {
	            return true;
	        }
	    }

	    return false;
	}
}
