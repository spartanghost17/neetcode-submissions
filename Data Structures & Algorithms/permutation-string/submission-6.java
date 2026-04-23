class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //a1b1c1 a1b1c1e3l1
        //int[] freqS1 = new int[26]
        //int[] freqS2 = new int[26]

        //for l = 0 -> s2, l++
            //idx = s2.charAt(l) - 'a'
            //if freqS1[idx] <= freqS2[idx]: -> good
            // lenSubstr = 1
            //iteration r = l+1, r++
            //idx2 = s2.charAt(r) - 'a'
            // if freqS1[idx2] > 0
        

        //return false
        //Input: s1 = "aabc", s2 = "lecabeea"
        int l = 0, k = s1.length();

        int[] freq1 = getFreq(s1);

        for(int r = k - 1; r < s2.length(); r++) {
            String window = s2.substring(l, r + 1);
            int[] freq2 = getFreq(window);
            if(Arrays.equals(freq1, freq2)) return true;
            else
                l++; //invalid window move left
        }

        return false;
    }

    public int[] getFreq(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        return freq;
    }
}
