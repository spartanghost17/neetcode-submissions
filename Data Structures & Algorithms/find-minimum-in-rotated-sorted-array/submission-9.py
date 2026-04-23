class Solution:
    def findMin(self, nums: List[int]) -> int:
        # [3,4,5,6,1,2]
        # [1, 2, 3, 4, 5, 6]
        # [6, 1, 2, 3, 4, 5]
        # [3, 4, 5, 6][1, 2]
        #  l              r
        # sum < target l++
        # r--
        # if nums[mid] <= currMin: currMin = mid
        #[1]
        # nums[mid] <= nums[r]: r = mid - 1
        # else: l = mid + 1

        # other approach:
        l = 0
        r = len(nums) - 1

        while l < r:

            mid = l + (r - l) // 2

            # Case 1: Minimum is in right half
            if nums[mid] > nums[r]:
                l = mid + 1

            # Case 2: Minimum is at mid or in left half
            else:
                r = mid

        return nums[l]


        # while l <= r:
        #     if nums[l] < nums[r]: # feasible?
        #         res = min(res, nums[l])
            
        #     mid = l + (r - l) // 2
        #     res = min(res, nums[mid])
        #     if nums[mid] > nums[r]:
        #         l = mid + 1
        #     else:
        #         r = mid - 1
        # return res

            
