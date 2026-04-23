class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:

        pre = [1] * len(nums)
        post = [1] * len(nums)
        res = [1] * len(nums)
        
        preVal = nums[0]
        pre[0] = 1
        for i in range(1, len(nums)):
            pre[i] = pre[i - 1] * preVal
            preVal = nums[i]

        postVal = nums[-1]
        post[len(nums) -1] = 1
        for i in range(len(nums) - 2, -1, -1):
            post[i] = post[i + 1] * postVal
            postVal = nums[i]

        for i in range(len(nums)):
            res[i] = pre[i] * post[i]

        return res

