class Solution:
    def minWindow(self, s: str, t: str) -> str:
        k = len(t)
        n = len(s)
        if n < k: 
            return ""

        freq = {}
        window = {}
        #{X: 1, Y: 1, Z: 1}
        for c in t:
            freq[c] = freq.get(c, 0) + 1

        need = len(freq)
        have = 0        
        #"OUZZ[ODZYX]AZV" -> XYZZ
        minLen = float("inf")
        res = []
        l = 0
        for r in range(len(s)):
            c = s[r]
            window[c] = window.get(c, 0) + 1
            if c in freq and window[c] == freq[c]:
                have += 1
            
            while have == need:
                # update minimum
                # decrease window
                if r - l + 1 < minLen:
                    minLen = r - l + 1
                    res = [l, r]
                cl = s[l]
                window[cl] -= 1
                # is window still valid?
                if cl in freq and window[cl] < freq[cl]:
                    have -= 1
                l += 1


        return s[res[0]: res[1] + 1] if len(res) > 0 else ""
            