class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        //"OUZZDYXAZV"
        //       ^

        // resLen = Integer.MAX_VALUE;
        // res = [-1, -1]
        // need = len(t)
        //for r in range(len(s)):
        // c = s[r]
        // window[c] = window.get(c, 0) + 1
        // if s[c] in freqT and window[c] == freqT[c]:
        // have +=1
        // while have == need:
        // update minimum (r - l + 1 < resLen): -> res = [l, r], resLen = r - l + 1
        // -> remove arr[l] from window; left++
        // window[s[l]] -= 1
        // if s[l] in freqT and window[s[l]] < freqT[s[l]]:-> have -= 1
        // l += 1
        //abc efg
        Map<Character, Integer> freqT = new HashMap<>();
        for(char c : t.toCharArray()) {
            freqT.put(c, freqT.getOrDefault(c, 0) + 1);
        }


        int resLen = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        int have = 0;
        int need = freqT.size();
        int l = 0;
        Map<Character, Integer> window = new HashMap<>();
        
        for(int r = 0; r < s.length(); r++) {
            
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if(freqT.containsKey(c) && window.get(c) == freqT.get(c)) {
                have++;
            }
            //"OUZZDYXAZV"
            //       ^
            while(have == need) {
                
                if(r - l + 1 < resLen) {
                    res[0] = l;
                    res[1] = r;
                    resLen = r - l + 1;
                }
                char c1 = s.charAt(l);
                //pop left
                window.put(c1, window.getOrDefault(c1, 0) - 1);
                if(freqT.containsKey(c1) && window.get(c1) < freqT.get(c1)) {
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0] , res[1] + 1);
    }
}
