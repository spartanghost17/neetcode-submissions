class Solution {
    public int characterReplacement(String s, int k) {
        /**
            XZAACBP k = 2
            Input: s = "AAABABB", k = 1
            l = 0, r = 0, res = 0, maxf = 0; -> map counts
            for i -> s
                counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1)
                maxf = max(maxf, counts.get(s.charAt(i)))

                while((r - l + 1) - maxf > k)
                    counts.put(s.charAt(i), counts.get(s.charAt(i)) - 1)
                    l++
                res =  max(res, r - l + 1)
            Output: 5

        */
        int l = 0, maxf = 0, res = 0;
        Map<Character, Integer> counts = new HashMap<>();
        
        for(int r = 0; r < s.length(); r++) {
            counts.put(s.charAt(r), counts.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, counts.get(s.charAt(r)));

            while((r - l + 1) - maxf > k) {
                counts.put(s.charAt(l), counts.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, (r - l + 1));
        }

        return res;
    }
}
