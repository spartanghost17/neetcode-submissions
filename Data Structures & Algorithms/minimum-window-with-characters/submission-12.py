class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t):
            return ""
        # shortest substring of s
        # every char in t including duplicates must be present in s
        # result valid even if permutated strings
        # !!= set
        # map = {X: 1, Y: 1, Z: 1}

        # can be upper case or lower case
        # X >= len(t) -> window is valid

        #"OUZODYXAZV"
        #-> "OUZZXXDYXAZV"
        #
        #X1Y1Z1 -> # map = {X: 1, Y: 1, Z: 1}
        #window is valid -> arr[r] is map and window.get(arr[r]) <= map.get(arr[r]) 
        # and completed == False and l < len(s)
        
        #window = {}
        # l = r
        # add arr[right] to window + 1
        #   # while window is valid:
        #       update minimum window if substring found
        #       remove arr[left] from window; left+=1

        freq_t = {}
        for c in t:
            freq_t[c] = freq_t.get(c, 0) + 1
        
        window = {}
        have = 0
        need = len(freq_t)
        
        res = [-1, -1]
        res_len = float("inf")

        l = 0
        for r in range(len(s)):
            c = s[r]
            window[c] = window.get(c, 0) + 1

            if c in freq_t and window[c] == freq_t[c]:
                have += 1
            
            while have == need: # while window is valid
                # update minimum
                if r - l + 1 < res_len:
                    res = [l, r]
                    res_len = r - l + 1

                # pop left
                window[s[l]] -= 1 # remove from window
                if s[l] in freq_t and window[s[l]] < freq_t[s[l]]: # decrease valid count
                    have -= 1
                l += 1
        l, r = res
        return s[l: r + 1] if res_len != float("inf") else ""


