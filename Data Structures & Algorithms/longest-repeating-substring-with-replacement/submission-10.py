class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        # return longest substring -> maxLen
        # k window size
        # frequency counter
        # window = defaultdict(0)
        # {A: 2}
        # map = new HashMap<>()
        # map.put(key, map.getOrDefault(key, 0) + 1)
        # map[key] = map.get(key, 0) + 1
        # add to window[right] 
        # while substr len - count most freq char in substr(map.get(right)) > k:
        #   remove from window[left]; -> remove from dict decrease count 
        #  left++
        # maxLen = max(maxLen, r - l + 1)

        #"AAABABB"
        #"AAABAXB"
        #"AXAAXAB" = 4

        left, max_len, maxf = 0, 0, 0
        window = defaultdict(int)
        for right in range(len(s)):
            window[s[right]] = window.get(s[right], 0) + 1
            maxf = max(maxf, window[s[right]])
            while right - left + 1 - maxf > k:
                window[s[left]] -= 1
                left += 1
            max_len = max(max_len, right - left + 1)

        return max_len