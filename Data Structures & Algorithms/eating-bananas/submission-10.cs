public class Solution {
    public int MinEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = piles.Max();
        int res = r;
        //[1, ..., 4]
        //1 -> max in piles
        while(l <= r) {
            int k = l + (r - l) / 2;
            int hrs = 0;
            foreach(int p in piles) {
                hrs += (int) Math.Ceiling((double)p / k);
            }
            
            if(hrs <= h) {
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
