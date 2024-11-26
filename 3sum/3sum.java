// Meta
class Solution {
    /**
     * Problem Hint: Given an integer array `nums`, find all unique triplets [nums[i], nums[j], nums[k]] 
     *               such that i != j != k and nums[i] + nums[j] + nums[k] == 0.
     * Solution: First, sort the array. Then, use a loop to fix one number and apply a two-pointer 
     *           approach to find the other two numbers. Skip duplicates to ensure unique triplets.
     * 
     * Time Complexity: O(n^2) - Sorting takes O(n log n), and for each element, the two-pointer 
     *                  technique processes the rest of the array in O(n).
     * Space Complexity: O(n) - Space used for sorting and the result list.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // Step 1: Sort the array to use the two-pointer technique effectively
        Arrays.sort(nums);
        
        // Step 2: Initialize a result list to store unique triplets
        List<List<Integer>> res = new ArrayList<>();

        // Step 3: Iterate through the array, treating each element as the first number in the triplet
        for (int i = 0; i < nums.length; i++) {
            // If the current number is greater than 0, break because no triplet can sum to 0
            if (nums[i] > 0) break;

            // Skip duplicate numbers to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Step 4: Use two pointers to find the remaining two numbers
            int l = i + 1; // Left pointer starts just after the fixed number
            int r = nums.length - 1; // Right pointer starts at the end of the array

            while (l < r) {
                // Calculate the sum of the current triplet
                int sum = nums[i] + nums[l] + nums[r];

                // If the sum is greater than 0, move the right pointer to the left
                if (sum > 0) {
                    r--;
                }
                // If the sum is less than 0, move the left pointer to the right
                else if (sum < 0) {
                    l++;
                }
                // If the sum equals 0, add the triplet to the result list
                else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    // Move both pointers to look for new unique pairs
                    l++;
                    r--;

                    // Skip duplicates for the left pointer
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }
        }

        // Step 5: Return the list of unique triplets
        return res;
    }
}
