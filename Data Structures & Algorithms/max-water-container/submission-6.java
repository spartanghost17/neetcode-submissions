class Solution {
    public int maxArea(int[] heights) {
        //l = 0, r = heights.length - 1 
        //h = min(heights[l], heights[r]) -> 1 | 6
        //w = r - l -> 7 | 6
        //area = w * h

        //if(nums[l] <= h) l++
        //else r--

        int l = 0, r = heights.length - 1;
        int maxArea = 0;

        while(l < r) {
            int h = Math.min(heights[l], heights[r]);
            int w = r - l;
            int area = w * h;
            maxArea = Math.max(maxArea, area);

            if(heights[l] <= h) l++;
            else r--;
        }

        return maxArea;
    }
}
