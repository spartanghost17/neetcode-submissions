class Solution:
    def maxArea(self, heights: List[int]) -> int:
        # w * h
        l, r = 0, len(heights) - 1
        maxVal = 0
        while l < r:
            width = min(heights[l], heights[r]) * (r - l)    
            maxVal = max(maxVal, width)
            if heights[l] < heights[r]:
                l += 1
            else:
                r -= 1 
        return maxVal
            