//Uber
class Solution {
    /**
     * Problem Hint: Check if two strings `s` and `t` are anagrams of each other. 
     *               An anagram means both strings contain the same characters 
     *               with the same frequencies.
     * Solution: First, check if `s` and `t` have the same length; if not, return false.
     *           Use an integer array of size 26 to count character frequencies. 
     *           As we iterate through `s` and `t` simultaneously, increment for each character 
     *           in `s` and decrement for each character in `t`. If all counts end up as zero, 
     *           `s` and `t` are anagrams.
     * 
     * Time Complexity: O(n) - We iterate through both strings `s` and `t` once, 
     *                  where `n` is the length of the strings.
     * Space Complexity: O(1) - The integer array for character counts has a fixed size of 26.
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] arr = new int[26];
        
        // Increment for `s` character and decrement for `t` character simultaneously
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
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
