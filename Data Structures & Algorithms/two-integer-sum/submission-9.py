class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}
        for i, v in enumerate(nums):
            comp = target - v
            if comp in seen:
                return [seen.get(comp), i]
            seen[v] = i
        
        return []
