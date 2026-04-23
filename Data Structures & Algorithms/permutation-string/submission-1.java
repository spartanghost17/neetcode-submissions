class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        // Frequency arrays for s1 and the current window in s2
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        // Count the frequency of characters in s1
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        // Initialize the window with the first part of s2
        for (int i = 0; i < s1.length(); i++) {
            windowCount[s2.charAt(i) - 'a']++;
        }

        // Sliding window over s2
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (Arrays.equals(s1Count, windowCount)) {
                return true;
            }

            // Slide the window: remove the count of the outgoing character
            windowCount[s2.charAt(i) - 'a']--;
            // Add the count of the new character
            windowCount[s2.charAt(i + s1.length()) - 'a']++;
        }

        // Check the last window after the loop ends
        return Arrays.equals(s1Count, windowCount);
    }
}
