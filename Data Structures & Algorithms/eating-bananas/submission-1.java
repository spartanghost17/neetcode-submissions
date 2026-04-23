class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while(l <= r) {
            int k = l + (r - l) / 2;

            int totalTime = 0;
            for(int bananas : piles) {
                totalTime += Math.ceil((double) bananas / k);
            }
            if(totalTime <= h) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }

        }   

        return res;     
    }
}
