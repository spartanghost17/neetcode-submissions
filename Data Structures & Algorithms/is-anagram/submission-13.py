class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # l, r = 0, max(len(s), len(t))
        # while l < r:
        #     while 

        #     l += 1
        #     r -= 1
        # return True
        return self.get_freq_key(s) == self.get_freq_key(t)
    
    def get_freq_key(self, s: str) -> str:
        #seen = [0 for i in range(26)]
        seen = [0] * 26
        for c in s:
            seen[ord('a') - ord(c)] += 1
        
        sb = []
        for i, val in enumerate(seen):
            if val != 0:
                sb.append(chr(ord('a') + i))
                sb.append(str(seen[i]))
        
        return "".join(sb)