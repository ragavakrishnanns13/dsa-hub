// Spotify
class Solution {
    /**
     * Problem Hint: Given a string `s`, determine if it is a palindrome, considering only 
     *               alphanumeric characters and ignoring cases. A palindrome reads the 
     *               same forward and backward after filtering non-alphanumeric characters.
     * Solution: Use two pointers, one starting from the beginning (`l`) and the other 
     *           from the end (`r`). Skip non-alphanumeric characters and compare 
     *           characters case-insensitively.
     * 
     * Time Complexity: O(n) - Each character in the string is processed at most once.
     * Space Complexity: O(1) - No additional space is used apart from a few variables.
     */
    public boolean isPalindrome(String s) {
        // Initialize two pointers: l starts at the beginning, r starts at the end
        int l = 0, r = s.length() - 1;

        // Traverse the string using the two pointers
        while (l < r) {
            // Move the left pointer forward if the current character is not alphanumeric
            while (l < r && !isAlphaNum(s.charAt(l))) {
                l++;
            }
            // Move the right pointer backward if the current character is not alphanumeric
            while (l < r && !isAlphaNum(s.charAt(r))) {
                r--;
            }
            // Compare the characters at the two pointers (case-insensitive)
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false; // If they don't match, the string is not a palindrome
            }
            // Move the pointers closer for the next comparison
            l++;
            r--;
        }

        // If all comparisons pass, the string is a palindrome
        return true;
    }

    /**
     * Helper function to check if a character is alphanumeric (a-z, A-Z, 0-9).
     * @param c The character to check
     * @return True if the character is alphanumeric, false otherwise
     */
    public boolean isAlphaNum(char c) {
        return (
            (c >= 'A' && c <= 'Z') || // Check if the character is an uppercase letter
            (c >= 'a' && c <= 'z') || // Check if the character is a lowercase letter
            (c >= '0' && c <= '9')    // Check if the character is a digit
        );
    }
}
