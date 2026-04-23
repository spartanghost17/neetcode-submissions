class Solution {
    public int maxArea(int[] heights) {
        //
        //r = nums.length - 1
        //maxWater = 0
        //for i -> nums
        //h=[1,7,2,5,4,7,3,6]
        // l = i
        //while(l < r)
            //width = r - l;
            //height = Math.min(nums[l], nums[r])
            //currMaxWater = width * height
            //maxWater = Math.max(maxWater, currMaxWater)
        int l = 0;
        int r = heights.length - 1;
        int res = 0;
        
        while(l < r) {
            int width = Math.min(heights[l], heights[r]);
            int height = r - l;
            int area = width * height;
            res = Math.max(res, area);

            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }

        }
        
        return res;
    }
}
