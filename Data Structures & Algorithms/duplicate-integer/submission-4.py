class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        seen = {}
        for i, val in enumerate(nums):
            if val in seen:
                return True
            seen[val] = seen.get(val, 0) + 1
        return False