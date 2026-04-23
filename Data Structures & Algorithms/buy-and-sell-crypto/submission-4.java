class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1, maxProfit = 0;
        // [10,1,5,6,7,1]
        //     ^ ^
        //if(nums[l] < nums[r]) max(max, nums[l] - nums[r])
        //if(nums[l] >= nums[r]) l = r
        while(r < prices.length) {
            if(prices[l] < prices[r]) 
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            else
                l = r;
            r++;
        }
        return maxProfit;
    }
}
