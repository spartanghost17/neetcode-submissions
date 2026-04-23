class Solution {
    public boolean isAnagram(String s, String t) {
        //Input: s = "jar", t = "jam"
        //j1a1r1 j1a1r1
        //[0 - 25]
        //int a = 'a'
        //int idx = 'b' - 'a' = 1
        //sb.append("a").append(1) = a1c1r1
        String freq1 = getFreqString(s);
        String freq2 = getFreqString(t);

        return freq1.equals(freq2);  
    }

    public String getFreqString(String s) {
        int[] freq = new int[26];
        
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        } 

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < freq.length; i++) {
            if(freq[i] > 0) 
                sb.append((char)('a' + i)).append(freq[i]);
        }

        return sb.toString();
    }
}
