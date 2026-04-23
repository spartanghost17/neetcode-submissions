class Solution {
    public boolean isAnagram(String s, String t) {  
        //car -> rac
        //ca -> rac
        //Arrays.sort(s.toCharArray())//(n log n)
        //O(n)
        //[26]
        //int[] freq = new int[26]
        //int a = 'a'//126 + 1
        //freq[c - 'a']++
        //a1c1r1             
        return getFrequency(s).equals(getFrequency(t));     
    }

    public String getFrequency(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < freq.length; i++) {
            if(i > 0) 
                sb.append((char)('a' + i)).append(freq[i]);
        }

        return sb.toString();
    }
}
