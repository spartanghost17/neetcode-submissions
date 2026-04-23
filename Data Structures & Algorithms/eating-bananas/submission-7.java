class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt(), res = 0;
        while(l <= r) {//O(log(n))
            int k = l + (r - l) / 2;
            int totalTime = 0;
            for(int i = 0; i < piles.length; i++) {//O(n)
                totalTime += Math.ceil((double) piles[i] / k);
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
