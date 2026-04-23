class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] freqs = new List[nums.length + 1];

        for(int i = 0; i <= nums.length; i++) {
            freqs[i] = new ArrayList<>();
        }

        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freqs[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        
        for(int i = freqs.length - 1; i > 0 && index < k; i--) {
            for(int n : freqs[i]) {
                res[index++] = n;
                if(index == k) {
                    return res;
                }
            }
        }

        return res;
    }
}

/*class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //map {num, freq}
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int key = nums[i];
            map.put(key, map.getOrDefault(key, 0) + 1);     
        }
        
        // Create a max-heap based on frequency
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new FrequencyComparator());

        // Add pairs to the max-heap
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();
            maxHeap.add(new int[]{number, frequency});
        }

        int[] answer = new int[k];
        // Extract elements from the max-heap and print
        int i = 0;
        while (!maxHeap.isEmpty() && k > 0) {
            int[] pair = maxHeap.poll();
            int number = pair[0];
            int frequency = pair[1];
            
            answer[i] = number;
            k--;
            System.out.println("Number: " + number + ", Frequency: " + frequency);
        }

        return answer;
    }
}

// Custom comparator for max-heap based on frequency
static class FrequencyComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] p1, int[] p2) {
        // Max-heap: higher frequency comes first
        return Integer.compare(p2[1], p1[1]); // p2[1] is frequency of p2, p1[1] is frequency of p1
    }
}*/
