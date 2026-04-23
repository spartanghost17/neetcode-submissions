class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //{1: 1, 2: 2, 3: 3}
        //arr=[[1,1],[2,2], [3,3], [5,1]]
        //Arrays.sort(arr, (a,b) -> b[1] - a[1])
        //O(n + logn)

        //O(n + k)
        //O(n * log k)
        //PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> b[1] - a[1])
        
        // Map<Integer, Integer> map = new HashMap<>();
        // PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]); 
        // for(int i = 0; i < nums.length; i++) {
        //     map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        // }

        // for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
        //     minHeap.offer(new int[] {entry.getKey(), entry.getValue()});
        //     if(minHeap.size() > k) {
        //         minHeap.poll();
        //     }
        // }
        // int[] res = new int[k];
        // for(int i = 0; i < k; i++) {
        //     res[i] = minHeap.poll()[0];
        // }

        // return res;

        //O(n) + O(n) + O(k) -> n + k -> O(n)
        //O(n)
        //[1,2,2,3,3,3] k=1
        //[0,   1,   2,    3,   4,  5, 6]
        //[[], [1], [2], [3,4], [], [] []] 
        //Arrays.stream(buckets[i]).min().getAsInt()

        //O(n) -> O(n)
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length + 1];

        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for(int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        //{1:1, 2:2, 3:3, 4:3}
        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int counter = 0;
        for(int i = buckets.length - 1; i > 0; i--) {
            for(int j : buckets[i]) {
                res[counter++] = j;
                //res[counter] = j
                //counter +=1
                if(counter == k) {
                    return res;
                }
            }
        }

        return res;
    }   
}
