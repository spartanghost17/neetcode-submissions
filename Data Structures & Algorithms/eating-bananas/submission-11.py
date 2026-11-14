class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l, r = 1, max(piles)
        res = 0

        while l <= r:
            #1 + 1 + 2 + 2 = 6
            #[1, 2, 3, 4] -> [0, 0, 0, 0] = 6
            #mid = l + (r - l) // 2
            k = l + (r - l) // 2
            t = 0
            for i in range(len(piles)):
                t += math.ceil(piles[i] / k)
            
            if t <= h:
                res = k
                r = k - 1
            else:
                l = k + 1
        
        return res

