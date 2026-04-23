public class Solution {
    public int MaxArea(int[] heights) {
        int l = 0; int r = heights.Length - 1;
        int best = 0;
        while(l < r) {
            int h = Math.Min(heights[l], heights[r]);
            int w = r - l;
            int area = w * h;
            best = Math.Max(area, best);
            if(heights[l] <= heights[r]) l++;
            else r--;
        }

        return best;
    }
}
