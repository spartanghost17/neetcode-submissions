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
        Map<Character, Integer> window = new HashMap<>();
        int l = 0, maxLen = 0, maxF = 0;
        for(int r = 0; r < s.length(); r++) {
            window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(maxF, window.get(s.charAt(r)));
            while(r - l + 1 - maxF > k) {
                window.put(s.charAt(l), window.get(s.charAt(l)) - 1);
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
