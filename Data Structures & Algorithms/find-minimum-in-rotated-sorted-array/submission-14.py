class Solution:
    def findMin(self, nums: List[int]) -> int:
        l, r = 0, len(nums) - 1
        # [3,4,5,6,1,2] -> 
        # res: int = nums[0]

        while l < r:
            if nums[l] < nums[r]:
                return nums[l]
            
            mid: int = l + (r - l) // 2
            
            if nums[mid] > nums[r]:
                l = mid + 1
            else:
                r = mid

        return nums[l]
