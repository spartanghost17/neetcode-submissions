class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //n log n + 1 log n ->  O(n log n)

        //[4,10,23,25]
        //[-6, 0, 13, 25]
        //[1,2,3,4]
        // k = 3
        //[-1, 0, -1, 0]
        //[0, 0, 0, 0].sum()
        //mid 1
        //for -> k
        //for(i = 0; i < k; i++)

        //  if(copy[i] > 0)

        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while(l <= r) {
            int k = (r + l) / 2;
            long totalTime = 0;
            for(int p : piles) {
                totalTime += (long) Math.ceil((double) p / k);
            }
            if(totalTime <= h) {
                res = k;
                r = k - 1;
            }
            else {
                l = k + 1;
            }
        }

        return res;
    }
}
