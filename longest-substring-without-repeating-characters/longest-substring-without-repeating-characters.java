class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0; // Left pointer
        int maxLen = 0; // To store the max length of the substring
        int[] arr = new int[26]; // Array to store the last seen index of each character
        
        for (int r = 0; r < s.length(); r++) {
            // Get the index of the current character (convert 'a' to 0, 'b' to 1, ..., 'z' to 25)
            int currCharIndex = s.charAt(r) - 'a';
            
            // If the character was seen before and is within the current window
            if (arr[currCharIndex] > 0) {
                // Move the left pointer to the right of the last seen position
                l = Math.max(l, arr[currCharIndex]);
            }
            
            // Update the last seen index of the character (1-based index)
            arr[currCharIndex] = r + 1;
            
            // Calculate the length of the current substring and update the max length
            maxLen = Math.max(maxLen, r - l + 1);
        }
        
        return maxLen; // Return the maximum length found
    }
}
