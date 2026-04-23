class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //piles = [1,4,3,2], h = 9
        //1 = 10
        //2 = 6
        //[1,2,3,4]
        //[1,2,3,4,5,6]
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;
        while(l <= r) {
            int k = l + ((r - l) / 2);
            int eatingTime = 0;
            for(int p : piles) {
                eatingTime += Math.ceil((double) p / k);
            }

            if(eatingTime <= h) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1; 
            }
        }

        return res;
    }
}
