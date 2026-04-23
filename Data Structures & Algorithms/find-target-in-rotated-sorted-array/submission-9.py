class Solution:
    def search(self, nums: List[int], target: int) -> int:
        res = -1
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid] == target:
                return mid
            # Case 1: Left half is sorted
            if nums[l] <= nums[mid]:
                # Target is inside left sorted half 
                # (value is below the mid point)
                if nums[l] <= target and target < nums[mid]:
                    r = mid - 1
                # Target is not inside left sorted half
                # value is above the mid point (either nums[l] > target or nums[mid] < target)
                else:
                    l = mid + 1

            # Case 2: Right half is sorted (nums[l] > nums[mid])
            else:
                # Target is inside right sorted half
                # move left pointer
                if nums[l] > target and nums[mid] <= target:
                    l = mid + 1
                else:
                    r = mid - 1
        return res