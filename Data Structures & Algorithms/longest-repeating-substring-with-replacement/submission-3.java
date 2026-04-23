class Solution {
    public int characterReplacement(String s, int k) {
        //5 - 0 + 1 - 4
        // Input: s = "XYYX", k = 2

        // Output: 4
        
        //Input: s = "AAABABB", k = 1
                        // ^
        //Output: 5// {A: 3, B: 1}
        //5 - 4 = 1 > k
        //while substrLen - maxF > k -> map of charAt(l) - 1; l++,  
        //l = 0, r = 2, maxf = 3 > k
        //l++

        //res = Math.max(res, substrLen)//5
        Map<Character, Integer> count = new HashMap<>();
        int res = 0, l = 0, maxf = 0;
        for(int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, count.get(s.charAt(r)));

            while((r - l + 1) - maxf > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
                maxf--;
                maxf = Math.max(maxf, count.get(s.charAt(l)));
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
