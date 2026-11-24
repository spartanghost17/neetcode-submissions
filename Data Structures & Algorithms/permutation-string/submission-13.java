class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> have = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        int k = s1.length();

        for(int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
            have.put(s2.charAt(i), have.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if(have.equals(need)) return true;

        for(int r = k; r < s2.length(); r++) {
            // add to window
            char c = s2.charAt(r);
            have.put(c, have.getOrDefault(c, 0) + 1);

            // left
            int left = r - k;
            char lc = s2.charAt(left);
            have.put(lc, have.getOrDefault(lc, 0) - 1);

            if(have.get(lc) == 0) {
                have.remove(lc);
            }

            if(have.equals(need)) return true;
        }

        return false;
    }


    // public boolean checkInclusion(String s1, String s2) {
    //     int k = s1.length();
    //     int n = s2.length();
    //     if(n < k) return false;

    //     int[] freq1 = new int[26];
    //     int[] window = new int[26];

    //     for(char c : s1.toCharArray()) {
    //         freq1[c - 'a']++;
    //     }

    //     int l = 0;
    //     for(int r = 0; r < s2.length(); r++) {
    //         char c = s2.charAt(r);
    //         window[c - 'a']++;
    //         if(r - l + 1 > k) {
    //             window[s2.charAt(l) - 'a']--;
    //             l++;
    //         }
    //         if(Arrays.equals(freq1, window)) return true;
    //     }

    //     return false;
    // }

}
