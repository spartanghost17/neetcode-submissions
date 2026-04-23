class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //strs[] -> [[anagram-group-1] [anagram-group-2]]
        //a1c1t1 = a1c1t1
        //{freqS: List[anagram-group-1], freqS2: List[anagram-group-2]}
        Map<String, List<String>> anagramGroups = new HashMap<>();
        
        for(String s : strs) {//O(m * n)
            String freq = getFrequency(s);
            if(!anagramGroups.containsKey(freq)){
                anagramGroups.put(freq, new ArrayList<>());
            }
            anagramGroups.get(freq).add(s); 
        }

        return anagramGroups.values().stream().toList();
    }

    public String getFrequency(String s) {
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for(int i = 0; i < freq.length; i++) {
            
            if(freq[i] > 0)
                sb.append((char)('a' + i)).append(freq[i]);
        }

        return sb.toString();
    }
}
