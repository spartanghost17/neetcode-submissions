class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length + 1];

        for(int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int count = 0;
        int[] res = new int[k];

        for(int i = buckets.length - 1; i > 0 && count < k; i--) {
            for(Integer val : buckets[i]) {
                if(count < k) {
                    res[count++] = val;
                }
            }
        }

        return res;
    }
}
