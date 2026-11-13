class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        seen = set()
        for i, v in enumerate(nums):
            if v in seen:
                return True
            seen.add(v)

        return False