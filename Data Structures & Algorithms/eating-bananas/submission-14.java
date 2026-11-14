class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        int res = 0;
        // O = O(n * log m) -> n array size * max number of bananas
        while(l <= r) { // O(log m)
            int k = l + (r - l) / 2;
            long t = 0;
            
            for(int p : piles) { // O(n)
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
