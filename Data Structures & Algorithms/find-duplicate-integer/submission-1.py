class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        # [1,2,3,2,2]
        # [1, 1]
        # idx 0 -> 1
        # idx 1 -> 2
        # idx 2 -> 3
        # idx 3 -> 2
        # idx 4 -> 2

        # detect cycle
        slow, fast = 0, 0
        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            if slow == fast:
                break
        
        slow2 = 0
        while slow != slow2:
            slow = nums[slow]
            slow2 = nums[slow2]
        
        return slow
        
