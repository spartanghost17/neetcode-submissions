class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // int size = nums.length - (k - 1); 
        // int[] res = new int[size];
        // int l = 0;

        // PriorityQueue<Integer> window = new PriorityQueue<>((a, b) -> b - a);
        // for(int r = 0; r < nums.length; r++) {
        //     window.offer(nums[r]);
        //     while(r - l + 1 > k && !window.isEmpty()) {
        //         window.remove(Integer.valueOf(nums[l]));//remove from window
        //         l++;
        //     }

        //     if(r - l + 1 == k) res[l] = window.peek();
        // }

        // return res;

        
        int[] output = new int[nums.length - k + 1];
        int idx = 0;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]); 
        for(int i = 0; i < nums.length; i++) {
            maxHeap.offer(new int[]{nums[i], i});
            // if window invalid
            if(i >= k - 1) {
                while(maxHeap.peek()[1] <= i - k) {
                    maxHeap.poll();
                }
                output[idx++] = maxHeap.peek()[0];
            }
        }

        return output;
    }
}
