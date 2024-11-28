class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[26]; // Frequency array for s1
        int[] window = new int[26]; // Frequency array for the current window in s2

        int n = s1.length();
        int m = s2.length();

        // If s1 is longer than s2, permutation is not possible
        if (n > m) return false;

        // Populate the frequency array for s1
        for (int i = 0; i < n; i++) {
            arr[s1.charAt(i) - 'a']++;
        }

        // Sliding window approach
        for (int i = 0; i < m; i++) {
            // Add the current character to the window
            window[s2.charAt(i) - 'a']++;

            // Remove the character that goes out of the window
            if (i >= n) {
                window[s2.charAt(i - n) - 'a']--;
            }

            // Compare the window array with the arr array
            if (matches(arr, window)) {
                return true;
            }
        }

        return false;
    }

    // Helper method to check if two frequency arrays match
    private boolean matches(int[] arr, int[] window) {
        for (int i = 0; i < 26; i++) {
            if (arr[i] != window[i]) {
                return false;
            }
        }
        return true;
    }
}
