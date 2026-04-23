class Solution:
    def maxArea(self, heights: List[int]) -> int:
       
       # maxArea = 0
       # height = min(heights[l], heights[r])
       # width = r - l
       # currArea = height * width
       # maxArea = max(currArea, maxArea)
       # small(l <= r) l++
       # big r-- 
        l, r = 0, len(heights) - 1
        maxArea = 0
        while l < r:
            height = min(heights[l], heights[r])
            width = r - l
            currArea = height * width
            maxArea = max(currArea, maxArea)
            if heights[l] <= heights[r]: 
                l+=1
            else: 
                r-=1
        
        return maxArea