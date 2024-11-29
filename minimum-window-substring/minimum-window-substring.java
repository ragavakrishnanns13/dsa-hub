//Airbnb
public class Solution {
    /**
     * Problem: Find the minimum window substring in `s` that contains all the characters of string `t`.
     *          If no such substring exists, return an empty string.
     * 
     * Approach:
     * 1. Use a sliding window technique with two pointers (`l` and `r`) to identify the substring.
     * 2. Maintain two hash maps:
     *    - `countT` to store the frequency of characters in `t`.
     *    - `window` to store the frequency of characters in the current sliding window of `s`.
     * 3. Expand the right pointer (`r`) to include characters in the window.
     * 4. Once the window contains all characters of `t` (with the required frequencies), try shrinking it 
     *    from the left (`l`) to find the smallest valid window.
     * 
     * Time Complexity: O(n) - Both pointers (`l` and `r`) traverse `s` once, and all map operations are O(1).
     * Space Complexity: O(|t| + |s|) - Hash maps store up to the size of `t` and `s`.
     * 
     * @param s The string in which to search for the substring.
     * @param t The string whose characters must be contained in the substring of `s`.
     * @return The smallest substring of `s` that contains all characters of `t`, or an empty string if none exists.
     */
    public String minWindow(String s, String t) {
        // Result array to store the start and end indices of the minimum window substring.
        int[] res = {-1, -1};

        // Frequency map for characters in `t`.
        Map<Character, Integer> countT = new HashMap<>();

        // Frequency map for characters in the current sliding window of `s`.
        Map<Character, Integer> window = new HashMap<>();

        // Length of the minimum window found so far.
        int resLen = Integer.MAX_VALUE;

        // Variables to track the number of valid characters in the window.
        int have = 0, need = 0;

        // Left pointer for the sliding window.
        int l = 0;

        // Populate `countT` with the frequencies of characters in `t`.
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        need = countT.size(); // Total number of unique characters needed in the window.

        // Iterate through `s` using the right pointer (`r`).
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            // Add the current character to the sliding window frequency map.
            window.put(c, window.getOrDefault(c, 0) + 1);

            // If the character's frequency matches the required frequency, increment `have`.
            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }

            // Shrink the window from the left as long as it remains valid.
            while (have == need) {
                // Update the result if the current window is smaller than the previously found minimum.
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                // Remove the leftmost character from the window.
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);

                // If removing the character makes the window invalid, decrement `have`.
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }
                l++; // Move the left pointer to shrink the window.
            }
        }

        // If no valid window was found, return an empty string.
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
