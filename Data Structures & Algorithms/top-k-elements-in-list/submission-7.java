class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //{1: 1, 2: 2, 3: 3} -> int[]{key, val} -> sort
        //Arrays.sort(arr, (a, b) -> b[1] - a[1])//
        //(n log n)

        //{1: 1, 2: 2, 3: 1}
        //minHeap<int[]> -> {key, val} -> (a,b) -> a[1] - b[1]
        //k log n

        // Map<Integer, Integer> counts = new HashMap<>();
        // PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]); 
        // for(int n : nums) {
        //     counts.put(n, counts.getOrDefault(n, 0) + 1);
        // }   
    
        // //O( k log n)
        // for(Map.Entry<Integer, Integer> entry : counts.entrySet()) {
        //     minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
        //     if(minHeap.size() > k) {
        //         minHeap.poll();
        //     }
        // }
        // int[] res = new int[k];
        // for(int i = 0; i < k; i++) {
        //     res[i] = minHeap.poll()[0];
        // }

        //[0,  1,    2,   3,  4,  5, 6]
        //[   [1], [2], [3], [], [] []]
        Map<Integer, Integer> counts = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length + 1];

        for(int i = 0; i < nums.length; i++) {
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
        }

        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int counter = 0;

        for(int freq = buckets.length - 1; freq >= 0 && counter < k; freq--) {
            for(int val : buckets[freq]) {
                res[counter++] = val;
                if(counter == k) break;
            }
        }

        return res;
    }
}
