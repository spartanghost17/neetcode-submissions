class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}

        for i, v in enumerate(nums):
            val = target - v
            # {val, idx}
            if seen.get(val) is not None:
                return [seen.get(val), i]
            seen[v] = i
        
        return []

