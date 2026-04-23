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

        int[] topk = new int[k];
        int index = 0;

        for(int i = freqs.length - 1; i > 0 && index < k; i--) {

            for(int n : freqs[i]) {
                topk[index++] = n;
                if(index == k) {
                    return topk;
                }
            }
        }

        return topk;
    }
}















































/*class Solution {

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
}*/
