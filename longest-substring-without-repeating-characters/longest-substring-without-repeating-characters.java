//Meta
public class Solution {
    /**
     * Problem: Find the length of the longest substring without repeating characters.
     * Approach: Use the sliding window technique with two pointers (`l` and `r`) and a HashMap to 
     *           track the most recent index of each character. The left pointer (`l`) ensures that 
     *           the substring always contains unique characters. The right pointer (`r`) expands the 
     *           window as we iterate over the string.
     * 
     * Time Complexity: O(n) - The string is traversed once, and each character is processed at most twice.
     * Space Complexity: O(min(n, m)) - `n` is the length of the string, `m` is the size of the character set
     *                              (for example, 128 for ASCII).
     */
    public int lengthOfLongestSubstring(String s) {
        // HashMap to store the most recent index of each character.
        HashMap<Character, Integer> map = new HashMap<>();

        // Left pointer (l) of the sliding window, and variable (res) to store the result.
        int l = 0;
        int res = 0;

        // Iterate through the string using the right pointer (r).
        for (int r = 0; r < s.length(); r++) {
            // If the character at 'r' already exists in the HashMap, adjust the left pointer.
            if (map.containsKey(s.charAt(r))) {
                // Move the left pointer just past the previous occurrence of s[r].
                l = Math.max(l, map.get(s.charAt(r)) + 1);
            }

            // Update the HashMap with the current character and its index.
            map.put(s.charAt(r), r);

            // Calculate the length of the current window and update the result.
            res = Math.max(res, r - l + 1);
        }

        // Return the length of the longest substring found.
        return res;
    }
}
