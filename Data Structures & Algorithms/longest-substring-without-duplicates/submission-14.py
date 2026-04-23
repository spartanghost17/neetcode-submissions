class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        window = set()
        # zxyzxyz
        # ^
        # xzyz

        # longest & 
        # no duplicates -> grow window -> update max
        # is duplicate -> shrink until valid

        l = 0
        max_len = 0
        for r in range(len(s)):
            while s[r] in window: # invalid
                window.remove(s[l])
                l += 1
            window.add(s[r])
            max_len = max(max_len, r - l + 1)

        return max_len



