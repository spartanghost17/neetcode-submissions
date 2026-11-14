class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        int res = 0;
        
        while(l <= r) {
            int k = l + (r - l) / 2;
            long t = 0;
            
            for(int p : piles) {
                t += (int) Math.ceil((double) p / k);
            }

            if(t <= h) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return res;
    }
}
