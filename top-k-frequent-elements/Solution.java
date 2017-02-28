public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        
        for (int n : nums) {
            Integer itemCount = count.get(n);
            if (itemCount == null) {
                count.put(n, 1);
            } else {
                count.put(n, itemCount + 1);
            }
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((e1, e2) -> (e2.getValue() - e1.getValue()));
        
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            heap.add(entry);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(heap.poll().getKey());
        }
        
        return result;
    }
}
