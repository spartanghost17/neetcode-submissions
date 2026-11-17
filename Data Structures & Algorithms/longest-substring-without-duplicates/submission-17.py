class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # left = 0
        # answer = 0
        # state = {}

        # for right, value in enumerate(s):
        #     add_to_state(state, value)
        #     while not is_valid(state):
        #         remove_from_state(left)
        #         l++
        #     answer = max(res, r - l + 1)
        # return answer

        # s = "azxyzxyz"
        l: int = 0
        ans: int = 0
        state: set = set()

        for r, c in enumerate(s):
            
            while c in state:
                state.remove(s[l])
                l += 1

            state.add(c)
            ans = max(ans, r - l + 1)
        
        return ans
