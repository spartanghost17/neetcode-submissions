class Solution:
    def search(self, nums: List[int], target: int) -> int:
        res = -1
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid] == target:
                return mid

            # the left half is sorted
            if nums[l] <= nums[mid]:
                # value is below the mid point
                if nums[l] <= target and target < nums[mid]:
                    r = mid - 1
                # else value is above the mid point (either nums[l] > target or nums[mid] < target)
                else:
                    l = mid + 1

            # the right half is sorted (nums[l] > nums[mid])
            else:
                # move left pointer
                if nums[l] > target and nums[mid] <= target:
                    l = mid + 1
                else:
                    r = mid - 1
        return res