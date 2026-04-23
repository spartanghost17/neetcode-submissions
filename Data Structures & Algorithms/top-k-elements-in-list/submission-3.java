class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //[10]
        //O(k * log n)
        //O(n) [3,3,3,3,3,3]
        //[0,   1,    2,   3,  4,  5,  6]
        //[[0], [1], [2], [3], [], [], []]
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length + 1];

        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        //{1: 4}
        for(int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int counter = 0;

        for(int i = buckets.length - 1; i > 0; i--) {
            for(int j : buckets[i]) {
                res[counter++] = j;
                if(counter == k) {
                    return res;
                }
            }
        }

        return res;
    }
}
