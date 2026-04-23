class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, maxLen = 0;
        Set<Character> window = new HashSet<>();
        for(int r = 0; r < s.length(); r++) {
            while(window.contains(s.charAt(r))) { //invalid window
                window.remove(s.charAt(l));
                l++;
            }
            window.add(s.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
