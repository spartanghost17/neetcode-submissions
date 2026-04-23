class Solution {

    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int n = s2.length();
        if(n < k) return false;

        int[] freq1 = new int[26];
        int[] window = new int[26];

        for(char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        int l = 0;
        for(int r = 0; r < s2.length(); r++) {
            char c = s2.charAt(r);
            window[c - 'a']++;
            if(r - l + 1 > k) {
                window[s2.charAt(l) - 'a']--;
                l++;
            }
            if(Arrays.equals(freq1, window)) return true;
        }

        return false;
    }

//     public boolean checkInclusion(String s1, String s2) {
//         if(s2.length() < s1.length()) return false;
//         //a1b1c1
//         int k = s1.length();
//         int[] freq1 = getFreq(s1); //O(26)
//         boolean isPresent = false;
//         //Arrays.equals(arr1, arr2)
//         int l = 0;
//         for(int r = 0; r < s2.length() && r + k <= s2.length(); r++) { //O(m)
//             String window = s2.substring(l, r + k); //O(k)
//             int[] freq2 = getFreq(window);
//             if(Arrays.equals(freq1, freq2)) return true;
//             l++;
//         }

//         return false;
//     }

//     public int[] getFreq(String s) {
//         int[] freq = new int[26];
//         //[c - a]++
//         for(char c : s.toCharArray()) freq[c - 'a']++;//freq[ord(c) - ord('a')]
//         return freq;
//     }
}
