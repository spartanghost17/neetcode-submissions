class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        l: int = 0
        maxSell: int = 0

        for r in range(1, len(prices)):
            if prices[r] < prices[l]:
                l = r
            else:
                maxSell = max(maxSell, prices[r] - prices[l])

        return maxSell