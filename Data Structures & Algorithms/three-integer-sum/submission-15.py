class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        #[-4, -1, -1, 0, 1, 2]
        #
        res = []
        target = 0
        for i, v in enumerate(nums):
            if v > 0: 
                break
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            l, r = i + 1, len(nums) - 1
            while l < r:
                threeSum = nums[i] + nums[l] + nums[r]
                if threeSum == target:
                    res.append([nums[i], nums[l], nums[r]])
                    while l < r and nums[l] == nums[l + 1]:
                        l+=1
                    l+=1
                    r-=1
                elif threeSum < target:
                    l+=1
                else:
                    r-=1

        return res