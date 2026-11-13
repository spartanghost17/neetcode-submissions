class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # 0, 1, 2,    3, 4, 5, 6
        # [] [1][2,3] [] [] [] []

        # freq 
        # freq buckets
        # populate the buckets
        # traverse from the end k times

        freq = {}
        buckets = [[] for _ in range(len(nums) + 1)] # [0] * 26
                
        for _, v in enumerate(nums):
           freq[v] = freq.get(v, 0) + 1
        
        for num, count in freq.items():
            buckets[count].append(num)

        res: list = []
        count: int = 0

        for i in range(len(buckets) -1, 0, -1):
            for j, v in enumerate(buckets[i]):
                if count < k:
                    res.append(v)
                    count += 1

        return res       

