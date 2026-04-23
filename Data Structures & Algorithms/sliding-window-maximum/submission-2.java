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

        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] output = new int[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            heap.offer(new int[]{nums[i], i});
            if (i >= k - 1) {
                while (heap.peek()[1] <= i - k) {
                    heap.poll();
                }
                output[idx++] = heap.peek()[0];
            }
        }
        return output;
    }
}
