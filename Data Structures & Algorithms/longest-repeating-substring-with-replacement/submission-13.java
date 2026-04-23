class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int l = 0;
        //AAABBB k = 1
        Map<Character, Integer> window = new HashMap<>();
        int maxF = 0;
        for(int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
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
