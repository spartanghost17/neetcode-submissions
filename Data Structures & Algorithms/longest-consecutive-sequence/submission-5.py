class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        unique = set()
        longest = 0
        for i, num in enumerate(nums):
            unique.add(num)
        
        for i, num in enumerate(nums):
            currLen = 1
            if num - 1 not in unique:
                while num + currLen in unique:
                    currLen += 1
                longest = max(currLen, longest)

        return longest