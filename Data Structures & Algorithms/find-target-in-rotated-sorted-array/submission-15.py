class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1
        #[4,5,6,7,2,3]
        
        while l <= r: # O(log n)
            mid: int = l + (r - l) // 2

            if nums[mid] == target:
                return mid

            if nums[l] <= nums[mid]: # left half is sorted
                if nums[l] <= target and target < nums[mid]:
                    r = mid - 1 
                else: 
                    l = mid + 1
            else: # left half is not sorted
                if  nums[mid] < target and target <= nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1

            

        return -1