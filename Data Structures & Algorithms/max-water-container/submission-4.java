class Solution {
    public int maxArea(int[] heights) {
        int l = 0; 
        int r = heights.length - 1;
        int bestArea = 0;
        while(l < r) {

            int width = r - l;
            int height = Math.min(heights[l], heights[r]);
            int area = width * height;
            bestArea = Math.max(bestArea, area);

            if(heights[l] <= heights[r]) l++;
            else r--;
        }

        return bestArea;
    }
}
