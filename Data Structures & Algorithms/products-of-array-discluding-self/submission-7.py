class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        
        pre: list[int] = [1] * len(nums)
        pos: list[int] = [1] * len(nums)
        res: list[int] = [1] * len(nums)

        prev: int = nums[0]
        # pre[0] = 1
        for i in range(1, len(nums), 1):
            pre[i] = prev * pre[i - 1]
            prev = nums[i]
        
        post: int = nums[len(nums) - 1]
        # pos[len(nums) - 1] = 1
        for i in range(len(nums) - 2, -1, -1):
            pos[i] = post * pos[i + 1]
            post = nums[i]
        
        for i in range(len(nums)):
            res[i] = pre[i] * pos[i]

        return res
        
