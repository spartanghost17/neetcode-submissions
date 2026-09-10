class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> counts = new HashMap<>();
        int l = 0;
        
        //XZAXA k = 2
        //
        int maxf = 0;
        int longest = 0;
        for(int r = 0; r < s.length(); r++) {
            counts.put(s.charAt(r), counts.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, counts.get(s.charAt(r)));
            while(r - l + 1 - maxf > k) { //while window invalid
                counts.put(s.charAt(l), counts.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}
