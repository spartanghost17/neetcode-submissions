class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        seen = set()
        for _, v in enumerate(nums):
            seen.add(v)
        
        longest = 0

        for i in range(len(nums)):
            if (nums[i] - 1) not in seen:
                currL = 1
                while nums[i] + currL in seen:
                    currL += 1

                longest = max(longest, currL)
        
        return longest