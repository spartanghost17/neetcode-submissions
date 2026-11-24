class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False

        have: dict = {}
        need: dict = {}
        k: int = len(s1)

        for i in range(len(s1)):
            need[s1[i]] = need.get(s1[i], 0) + 1
            have[s2[i]] = have.get(s2[i], 0) + 1

        if need == have:
            return True

        for r in range(k, len(s2), 1):
            c = s2[r]
            have[c] = have.get(c, 0) + 1

            # remove from window on left side
            left = r - k
            lc = s2[left]
            have[lc] -= 1
            
            if have[lc] == 0:
                del have[lc]
            
            if have == need:
                return True

        
        return False
            
