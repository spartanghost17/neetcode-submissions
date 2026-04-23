class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int l = 0;
        int r = heights.length - 1;
        //O(n)
        while(l < r) {
            int w = r - l;
            int h = Math.min(heights[l], heights[r]);
            int area = w * h;
            max = Math.max(max, area);
            if(heights[l] <= heights[r]) l++;
            else r--;
        }

        return max;
    }
}
