class Solution {
    public int characterReplacement(String s, int k) {
        //26 -> map
        //l = 0, maxf = 0, res = 0
        //for r -> r++
        //count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1)
        //maxf = max(maxf, count.get(s.charAt(r)))

        //while (r - l + 1) - maxf > k : -> 
            //count.put(s.charAt(l), count.get(s.charAt(l)) - 1)
            //l++
            //maxf--
            //maxf = max(maxf, count.get(s.charAt(r)))
        
        //res = max(res, (r - l + 1))


        int l = 0, maxf = 0, res = 0;
        Map<Character, Integer> count = new HashMap<>();

        for(int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, count.get(s.charAt(r)));

            while((r - l + 1) - maxf > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
                maxf--;
                maxf = Math.max(maxf, count.get(s.charAt(l)));
            }

            res = Math.max(res, (r - l + 1));
        }

        return res;
    }
}
