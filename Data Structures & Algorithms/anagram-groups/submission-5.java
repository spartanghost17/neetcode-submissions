class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //{act: [act, cat]}
        //{a1c1t1: [act]}
        //freq = int[26] -> freq[c - 'a']++
        //sb.append(char).append(freq[i])
        Map<String, List<String>> anagramGroups = new HashMap<>();
        for(String s : strs) {//O(n)
            String freqS = getFrequency(s);
            if(!anagramGroups.containsKey(freqS)) {
                anagramGroups.put(freqS, new ArrayList<>());
            }
            anagramGroups.get(freqS).add(s);
        }

        return new ArrayList<>(anagramGroups.values());
    }


    public String getFrequency(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {//O(m)
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
