class Solution {
    public int maxProfit(int[] prices) {
        int maxVal = 0;
        int minVal = prices[0];
        //[10]
        for(int i = 0; i < prices.length; i++) {
            minVal = Math.min(minVal, prices[i]);
            maxVal = Math.max(maxVal, prices[i] - minVal);
        }

        return maxVal;
    }
}
