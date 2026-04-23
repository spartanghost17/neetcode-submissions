class Solution {
    public int maxArea(int[] heights) {
        //height = [1,7,2,5,4,7,3,6] //Output: 36
        // [2, 2, 2, 2] out: 4
        //go from left ++
        //len = r - l  , h = min.value([l], [r])**2
        int left = 0;
        int right = heights.length - 1;
        int res = Integer.MIN_VALUE;
        
        while(left < right) {
            int distance = right - left;
            int area = distance * Math.min(heights[left], heights[right]);
            res = Math.max(res, area); 
            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
