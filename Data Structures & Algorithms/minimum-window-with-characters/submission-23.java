class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> have = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int required = need.size();
        int formed = 0;

        int l = 0;

        int bestLength = Integer.MAX_VALUE;
        int bestL = 0;
        int bestR = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            // Expand window
            have.put(c, have.getOrDefault(c, 0) + 1);

            // Did we just satisfy one requirement?
            if (need.containsKey(c)
                    && have.get(c).equals(need.get(c))) {
                formed++;
            }

            // Minimum-window pattern:
            // while valid, record minimum and shrink
            while (formed == required) {

                int currLength = r - l + 1;

                if (currLength < bestLength) {
                    bestLength = currLength;
                    bestL = l;
                    bestR = r;
                }

                // Remove left character
                char leftChar = s.charAt(l);

                have.put(
                    leftChar,
                    have.get(leftChar) - 1
                );

                // Did removing it make the window invalid?
                if (need.containsKey(leftChar)
                        && have.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }

                l++;
            }
        }

        if (bestLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(bestL, bestR + 1);
    }
}
