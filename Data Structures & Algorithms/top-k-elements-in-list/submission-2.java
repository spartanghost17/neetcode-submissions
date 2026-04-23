class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // approach 1:
        // Map<Integer, Integer> freq = new HashMap<>();

        // for(int i : nums) {
        //     freq.put(i, freq.getOrDefault(i, 0) + 1);
        // }

        // // O(m log m)
        // freq.entrySet().stream()
        //     .sorted(Comparator.comparing((Map.Entry<Integer, Integer> e) -> e.getValue()).reversed())
        //     //.sorted(Comparator.comparing(e -> e.getValue())) //natural order
        //     .collect(Collectors.toMap(
        //         Map.Entry::getKey,
        //         Map.Entry::getValue,
        //         (e1, e2) -> e1,
        //         LinkedHashMap::new
        //     ));
        
        // 2: 
        // List<int[]> arr = new ArrayList<>();
        // for(Map.Entry<Interger, Interger> entry : freq.entrySet()) {
        //     arr.add(new int[]{entry.getValue(), entry.getKey()});
        // }
        // arr.sort((a, b) -> b[0] - a[0]);

        // O(m log m)
        // List<List<Integer>> arr = new ArrayList<>();

        // for(Map.Entry<Integer, Integer> entry: freq.entrySet()) {
        //     arr.add(Arrays.asList(entry.getValue(), entry.getKey()));
        // }

        // arr.sort((a, b) -> Integer.compare(b.get(0), a.get(0)));

        // int[] res = new int[k];
        // for(int i = 0; i < k; i++) {
        //     //res[i] = arr.get(i)[1];
        //     res[i] = arr.get(i).get(1);
        // }

        // return res;

        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];

        for(int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        for(int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            bucket[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int counter = 0;
        for(int i = bucket.length - 1; i > 0; i--) {
            for(int j : bucket[i]) {
                res[counter++] = j;
                if(counter >= k) {
                    return res;
                }
            }
        }

        return res;
    }
}
