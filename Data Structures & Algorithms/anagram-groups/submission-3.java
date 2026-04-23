class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //["act", "cat"] -> O(n^m)
        //[26]
        //int a = 'a'
        //freq[c - 'a']++
        //
        //a1c1t1 = a1c1t1
        //map = {a1c1t1: [act, cat]}
        //map.values().stream().collect(Collectors.toList());
        //map.values().stream().toList()
        //new ArrayList<>(map.values())
        Map<String, List<String>> anagramGroups = new HashMap<>();
        for(String s : strs) {
            String freqStr = getFreqString(s);
            // if(!anagramGroups.containsKey(freqStr)) {
            //     anagramGroups.put(freqStr, new ArrayList<>());
            // }
            // anagramGroups.get(freqStr).add(s);

            List<String> list = anagramGroups.getOrDefault(freqStr, new ArrayList<String>());
            list.add(s);
            anagramGroups.put(freqStr, list);
            
        }

        return anagramGroups.values().stream().toList();
    }


    public String getFreqString(String str) {
        int[] freq = new int[26];
        for(char c : str.toCharArray()) {
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
