class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int size = nums.length - (k - 1); 
        int[] res = new int[size];
        int l = 0;
        //[1]
        //[1, 2, 3, 4, 5]
        PriorityQueue<Integer> window = new PriorityQueue<>((a, b) -> b - a);
        for(int r = 0; r < nums.length; r++) {
            window.offer(nums[r]);
            while(r - l + 1 > k && !window.isEmpty()) {
                window.remove(Integer.valueOf(nums[l]));//remove from window
                l++;
            }

            if(r - l + 1 == k) res[l] = window.peek();
        }

        return res;
    }
}
