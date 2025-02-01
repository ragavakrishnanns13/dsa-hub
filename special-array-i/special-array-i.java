class Solution {
    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        // Iterate through the array and check adjacent pairs
        for (int i = 0; i < nums.length - 1; i++) {
            int current = nums[i];
            int next = nums[i + 1];

            // Check if both numbers have the same parity
            if ((current % 2) == (next % 2)) {
                return false; // Not special
            }
        }
        return true; 
    }
}