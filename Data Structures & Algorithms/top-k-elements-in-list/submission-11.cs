public class Solution {
    public int[] TopKFrequent(int[] nums, int k) {
        Dictionary<int, int> freq = new Dictionary<int, int>();
        List<int>[] buckets = new List<int>[nums.Length + 1];

        foreach(int i in nums) {
            //freq.Add(i, freq.GetValueOrDefault(i, 0) + 1);
            freq[i] = freq.GetValueOrDefault(i, 0) + 1;
        }

        for(int i = 0; i < buckets.Length; i++) {
            buckets[i] = new List<int>();
        }

        foreach(KeyValuePair<int, int> kv in freq) {
            buckets[kv.Value].Add(kv.Key);
        }

        int[] res = new int[k];
        int count = 0;
        //int count = k - 1;
        for(int i = buckets.Length - 1; i > 0 && count > -1; i--) {
            foreach(int val in buckets[i]) {
                if(count == k) break;
                res[count++] = val;
                //if(count == -1) break;
                //res[count--] = val;
            }
        }

        return res;
    }
}
