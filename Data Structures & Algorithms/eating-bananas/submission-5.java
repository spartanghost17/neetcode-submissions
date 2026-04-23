class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /**
            Input: piles = [1,4,3,2], h = 9
                -> 3/2 -> 1 -> ceil() -> 1
            Output: 2

            1 - 4 -> [1,2,3,4]

            while(l <= r):
                k = l + ((r + l) / 2)
                totalTime = 0
                for i -> piles: 
                    totalTime += Math.ceil((double) piles[i]/k)

                if(totalTime < h) {
                    res = k
                    r = k - 1
                } else {
                    l = k + 1
                }
        */

        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = 0;
        while(l <= r) {
            int k = l + ((r - l) / 2);
            int totalTime = 0;
            for(int pile : piles) {
                totalTime += Math.ceil((double) pile / k);
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
