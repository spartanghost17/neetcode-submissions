class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Input: nums = [1,2,2,3,3,3], k = 2

        // Output: [2,3]
        // {1: 1, 2: 2, 3: 3} -> [[1, 1], [2, 2], [3, 3]]
        // O(n log n)

        //maxHeap = 3, 2 -> O(k * log n)
        //nums = [1,2,2,3,3,3],

        //O(n)

        // Map<Integer, Integer> map = new HashMap<>();
        // PriorityQueue<List<Integer>> maxHeap = 
        //             new PriorityQueue<>((a, b) -> Integer.compare(b.get(1), a.get(1)));
        
        // for(int i = 0; i < nums.length; i++) {
        //     map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        // }

        // for(Map.Entry<Integer, Integer> entry : map.entrySet()) {         
        //     maxHeap.offer(Arrays.asList(entry.getKey(), entry.getValue()));
        // }

        // int[] res = new int[k];

        // for(int i = 0; i < k; i++) {
        //     res[i] = maxHeap.poll().get(0); 
        // }

        // return res;
        //[1, 1, 2, 3, 4, 100]
        //[1 - 100]
        //[0,   1,   2,   3,   4,   5,   6]
        //[[], [1], [2], [3], [],  [], []]

        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length + 1];

        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for(int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];//[2]
        int counter = 0;
        for(int i = buckets.length - 1; i > 0; i--) {
            for(int j : buckets[i]) {
                res[counter++] = j;
                if(counter == k) return res;
            }
        }

        return res;

    }
}
