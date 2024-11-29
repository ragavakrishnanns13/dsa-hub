public class Solution {
    /**
     * Problem: Given an array `nums` and a sliding window of size `k`, return the maximum 
     *          value in each sliding window as it moves from left to right across the array.
     * 
     * Approach:
     * 1. Use a double-ended queue (`Deque`) to store indices of elements in `nums`.
          The Deque i.e double ended queue is used as a monotonically decreasing queue (decreasing monotonic queue)
     * 2. Maintain the deque such that:
     *    - The front (`q.getFirst()`) always contains the index of the maximum element in the current window.
     *    - Elements that are smaller than the current number being added (`nums[r]`) are removed from the back.
     * 3. As the window slides, add results to the output array once the window size reaches `k`.
     * 4. Ensure elements that are no longer in the window are removed from the deque.
     * 
     * Time Complexity: O(n) - Each element is added to and removed from the deque at most once.
     * Space Complexity: O(k) - The deque stores at most `k` indices.
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        // Result array to store the maximum values for each window.
        int[] res = new int[n - k + 1];

        // Double-ended queue to store indices of array elements.
        Deque<Integer> q = new LinkedList<>();

        // Left (`l`) and right (`r`) pointers for the sliding window.
        int l = 0, r = 0;

        // Iterate through the array.
        while (r < n) {
            // Remove indices of elements from the back of the deque if they are smaller
            // than the current element, as they cannot be the maximum in any window.
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }

            // Add the current element's index to the deque.
            q.addLast(r);

            // Remove the front of the deque if it is out of the current window.
            if (l > q.getFirst()) {
                q.removeFirst();
            }

            // Once the window size reaches `k`, record the maximum value (nums[q.getFirst()])
            // for the current window in the result array.
            if ((r + 1) >= k) {
                res[l] = nums[q.getFirst()];
                l++; // Slide the window to the right by moving the left pointer.
            }

            // Move the right pointer forward.
            r++;
        }

        // Return the result array containing maximum values for all sliding windows.
        return res;
    }
}
