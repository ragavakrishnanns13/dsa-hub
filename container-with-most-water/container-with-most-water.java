//Meta & Google
public class Solution {
    /**
     * Problem: Find the maximum area of water a container can hold given heights of lines.
     * Approach: Use the two-pointer technique to calculate the area for all possible containers
     *           while narrowing down the search space to maximize the area.
     * 
     * Time Complexity: O(n) - The two pointers traverse the array once.
     * Space Complexity: O(1) - Only a few variables are used.
     */
    public int maxArea(int[] heights) {
        // Initialize two pointers: one at the start (l) and one at the end (r) of the array.
        int l = 0;
        int r = heights.length - 1;

        // Variable to store the maximum area found so far.
        int res = 0;

        // Iterate until the two pointers meet.
        while (l < r) {
            // Calculate the area for the current pair of lines.
            // The area is determined by the shorter line and the distance between the pointers.
            int area = Math.min(heights[l], heights[r]) * (r - l);

            // Update the result if the current area is greater than the maximum found so far.
            res = Math.max(res, area);

            // Move the pointer pointing to the shorter line to try finding a potentially larger area.
            if (heights[l] <= heights[r]) {
                l++; // Move the left pointer forward.
            } else {
                r--; // Move the right pointer backward.
            }
        }

        // Return the maximum area found.
        return res;
    }
}
