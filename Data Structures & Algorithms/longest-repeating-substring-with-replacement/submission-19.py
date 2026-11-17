class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        
        l: int = 0
        res: int = 0
        state: dict = {}
        mostFreq: int = 0

        for r, c in enumerate(s):
            # add to state
            count = state.get(c, 0) + 1
            state[c] = count
            mostFreq = max(mostFreq, count)

            # while is not valid (state)
            while (r - l + 1) - mostFreq > k:
                state[s[l]] = state.get(s[l], 0) - 1
                l += 1
            
            res = max(res, r - l + 1)
        
        return res