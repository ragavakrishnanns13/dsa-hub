//Google
public class Solution {
    /**
     * Problem: Given a string `s` and an integer `k`, return the length of the longest substring 
     *          that can be obtained by replacing at most `k` characters to make all the characters 
     *          in the substring the same.
     * 
     * Approach: Use the sliding window technique with two pointers (`l` and `r`). The `HashMap` keeps track 
     *           of character frequencies within the current window. We maintain the most frequent character 
     *           count (`maxFreq`) in the current window. If the number of characters in the window that 
     *           need to be replaced to make the substring uniform exceeds `k`, the window is adjusted by 
     *           incrementing the left pointer (`l`). At every step, calculate the length of the valid window 
     *           and update the result (`res`).
     * 
     * Time Complexity: O(n) - The string is traversed once. Each character is processed at most twice.
     * Space Complexity: O(1) - The space used by the `HashMap` is proportional to the number of unique characters 
     *                          (which is constant for a fixed character set, e.g., 26 for English alphabets).
     *
     */
    public int characterReplacement(String s, int k) {
        // HashMap to store character frequencies in the current window.
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Result to store the length of the longest valid substring.
        int res = 0;

        // Two pointers for the sliding window: left (`l`) and right (`r`).
        int l = 0;

        // Track the frequency of the most frequent character in the current window.
        int maxFreq = 0;

        // Expand the sliding window by moving the right pointer.
        for (int r = 0; r < s.length(); r++) {
            // Update the frequency of the character at position `r`.
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            // Update the maximum frequency of any character in the current window.
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));

            // Check if the current window is invalid (more than `k` replacements required).
            // `r - l + 1` is the total length of the window.
            // `r - l + 1 - maxFreq` is the number of replacements needed to make all characters the same.
            if ((r - l + 1 - maxFreq) > k) {
                // Shrink the window from the left by reducing the frequency of `s[l]` and moving `l` forward.
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            // Update the result with the maximum valid window size.
            res = Math.max(res, r - l + 1);
        }

        // Return the length of the longest valid substring.
        return res;
    }
}
