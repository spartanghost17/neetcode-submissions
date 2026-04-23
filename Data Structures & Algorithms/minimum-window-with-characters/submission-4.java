class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        
        // Frequency map for characters in t
        Map<Character, Integer> freqT = new HashMap<>();
        for (char c : t.toCharArray()) {
            freqT.put(c, freqT.getOrDefault(c, 0) + 1);
        }

        // Sliding window variables
        Map<Character, Integer> windowFreq = new HashMap<>();
        int have = 0, need = freqT.size(); // need is the number of unique characters in t
        int left = 0, minLength = Integer.MAX_VALUE, minLeft = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            // Check if we satisfied the count for this character
            if (freqT.containsKey(c) && windowFreq.get(c).intValue() == freqT.get(c).intValue()) {
                have++;
            }

            // Try to shrink the window from the left
            while (have == need) {
                // Update the result if the current window is smaller
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                // Shrink the window
                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                // If shrinking the window breaks the valid window, decrease 'have'
                if (freqT.containsKey(leftChar) && windowFreq.get(leftChar) < freqT.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }

        // Return the minimum window or an empty string if no valid window was found
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}
