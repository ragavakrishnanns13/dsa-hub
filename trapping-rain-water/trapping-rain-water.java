//Google
public class Solution {
    /**
     * Problem: Calculate the total amount of water that can be trapped between heights.
     * Approach: Use a two-pointer technique to compute the trapped water by comparing
     *           the shorter height at each end and moving the pointers inward.
     * 
     * Time Complexity: O(n) - Each element is processed at most twice.
     * Space Complexity: O(1) - Uses a constant amount of extra space.
     */
    public int trap(int[] height) {
        // Initialize variables to store the total trapped water.
        int res = 0;

        // Variables to track the maximum height seen from the left and right ends.
        int leftMax = 0, rightMax = 0;

        // Two pointers: l starts at the leftmost position and r at the rightmost position.
        int l = 0, r = height.length - 1;

        // Iterate while the left pointer is less than the right pointer.
        while (l < r) {
            // Compare the heights at the two pointers to decide which direction to process.
            if (height[l] <= height[r]) {
                // If the left side is shorter or equal, process the left pointer.
                if (leftMax > height[l]) {
                    // Water can be trapped if the current height is less than the maximum to the left.
                    res += leftMax - height[l];
                } else {
                    // Update the leftMax to the current height if it's the new maximum.
                    leftMax = height[l];
                }
                // Move the left pointer forward.
                l++;
            } else {
                // If the right side is shorter, process the right pointer.
                if (rightMax > height[r]) {
                    // Water can be trapped if the current height is less than the maximum to the right.
                    res += rightMax - height[r];
                } else {
                    // Update the rightMax to the current height if it's the new maximum.
                    rightMax = height[r];
                }
                // Move the right pointer backward.
                r--;
            }
        }

        // Return the total amount of trapped water.
        return res;
    }
}
