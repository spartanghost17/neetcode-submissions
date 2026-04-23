class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //n * log m
        //a1c1t1 = a1c1t1/O(n * m)
        //{a1c1t1: [act, cat]}
        Map<String, List<String>> anagramGroups = new HashMap<>();
        for(String s : strs) {
            String freq = getFreqString(s);
            if(!anagramGroups.containsKey(freq)) {
                anagramGroups.put(freq, new ArrayList<>());
            }
            anagramGroups.get(freq).add(s);
        }

        return new ArrayList(anagramGroups.values());
    }

    public String getFreqString(String s) {
        int[] freq = new int[26];
        //int a = 'a'//126
        //'b' - 'a'
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        //[1,1,1,...0]
        for(int i = 0; i < freq.length; i++) {
            if(freq[i] > 0) {
                sb.append((char)('a' + i)).append(freq[i]);
            }
        }
        return sb.toString();
    }
}
