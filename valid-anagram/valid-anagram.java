class Solution {
    /**
     * Problem Hint: Check if two strings `s` and `t` are anagrams of each other. 
     *               An anagram means both strings contain the same characters with 
     *               the same frequency.
     * Solution: Use an integer array of length 26 to count character occurrences 
     *           for each letter in `s` and decrement for each letter in `t`.
     *           If `s` and `t` are anagrams, all counts should end up as zero.
     * 
     * Time Complexity: O(n) - We iterate through both strings `s` and `t` once, 
     *                  where `n` is the maximum length of the two strings.
     * Space Complexity: O(1) - Since we use a fixed-size array (26) for character 
     *                   counts, space usage remains constant regardless of input size.
     */
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        
        // Increment count for each character in `s`
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        
        // Decrement count for each character in `t`
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
        }
        
        // Check if all counts are zero
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}
