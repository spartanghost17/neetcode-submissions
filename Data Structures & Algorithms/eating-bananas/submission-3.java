class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;
        while(l <= r) {
            int k = (r + l) / 2;
            int timeCounter = 0;
            for(int p : piles) {
                timeCounter += Math.ceil((double) p / k);
            }

            if(timeCounter <= h) {
                r = k - 1;
                res = k;
            } else {
                l = k + 1;
            }
        }

        return res;
    }
}
