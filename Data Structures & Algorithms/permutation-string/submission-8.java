class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        //a1b1c1
        int k = s1.length();
        int[] freq1 = getFreq(s1);
        boolean isPresent = false;
        //Arrays.equals(arr1, arr2)
        int l = 0;
        for(int r = 0; r < s2.length() && r + k <= s2.length(); r++) {
            String window = s2.substring(l, r + k);
            int[] freq2 = getFreq(window);
            if(Arrays.equals(freq1, freq2)) return true;
            l++;
        }

        return false;
    }

    public int[] getFreq(String s) {
        int[] freq = new int[26];
        //[c - a]++
        for(char c : s.toCharArray()) freq[c - 'a']++;//freq[ord(c) - ord('a')]
        return freq;
    }
}
