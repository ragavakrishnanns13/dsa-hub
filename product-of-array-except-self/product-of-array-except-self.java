// Amazon
class Solution {
    /**
     * Problem Hint: Given an array `nums`, return an array `res` where each element `res[i]` 
     *               is the product of all elements in `nums` except `nums[i]`.
     * Solution: Use a prefix and postfix product approach. The prefix product calculates 
     *           the product of all elements before the current index, and the postfix 
     *           product calculates the product of all elements after the current index.
     * 
     * Time Complexity: O(n) - We traverse the array twice, once for prefix and once for postfix.
     * Space Complexity: O(1) - The output array `res` is reused for prefix and postfix calculations.
     *                    (excluding the output array itself, which is required by the problem).
     */
    public int[] productExceptSelf(int[] nums) {
        // Create an array to store the result
        int[] res = new int[nums.length];
        
        // Initialize the first element of `res` to 1, as there are no elements to the left of the first element
        res[0] = 1;
        
        // Variable to keep track of the running prefix product
        int prefix = 1;
        
        // Step 1: Calculate the prefix product for each element and store it in `res`
        for (int i = 1; i < nums.length; i++) {
            prefix *= nums[i - 1]; // Multiply the prefix by the previous element
            res[i] = prefix;      // Store the prefix product in `res`
        }
        
        // Variable to keep track of the running postfix product
        int postfix = 1;
        
        // Step 2: Calculate the postfix product and multiply it with the corresponding prefix product in `res`
        for (int i = nums.length - 2; i >= 0; i--) {
            postfix *= nums[i + 1]; // Multiply the postfix by the next element
            res[i] *= postfix;      // Multiply the postfix product with the existing prefix product in `res`
        }
        
        // Return the final result array
        return res;
    }
}
