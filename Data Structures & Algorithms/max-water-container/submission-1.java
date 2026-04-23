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
        
        
        int maxWater = 0;
        for(int i = 0; i < heights.length; i++) {
            int l = i;
            int r = heights.length - 1;
            while(l < r) {
                int width = r - l;
                int height = Math.min(heights[l], heights[r]);
                int currMaxWater = width * height;
                maxWater = Math.max(maxWater, currMaxWater);
                r--;
            }
        }

        return maxWater;
    }
}
