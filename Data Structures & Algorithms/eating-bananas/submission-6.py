class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        # min k = 1       i = 0 < h = 9
        #                  4 + 3 + 2 + 1 <= h 
        #                  1 + 2 + 2 + 1
        # res = 0
        # [1, 4, 3, 2] -> [0, 0, 0, 0] 
        # 1 -> max(piles) -> monotonic ->+
        # 1 2 3 4 -> m = l + (r - l) // 2
        #   k = mid
        #   totalTime = 0 
        #   for i in range(len(nums)):
        #      totalTime += ceil(nums[i] / k)
        #   if totalTime <= h:
        #      res = k
        #      r = k - 1
        #   else:
        #      l = k + 1    

        res = 0
        l, r = 1, max(piles)
        while l <= r:
            k = l + (r - l) // 2
            totalTime = 0
            for i in range(len(piles)):
                totalTime += math.ceil(piles[i] / k)
            if totalTime <= h:
                res = k
                r = k - 1
            else:
                l = k + 1

        return res