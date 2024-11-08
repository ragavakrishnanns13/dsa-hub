class Solution {
    /**
     * Problem Hint: Given an array `nums` and a target integer, find the indices 
     *               of two numbers in `nums` that add up to the target.
     * Solution: Use a HashMap to store each number and its index as we iterate
     *           through the array. For each number, calculate the `remaining` 
     *           value needed to reach the target. If `remaining` is already in the map,
     *           we found a solution and return the indices.
     * 
     * Time Complexity: O(n) - We traverse the array once, and HashMap operations 
     *                  (put and containsKey) are O(1) on average.
     * Space Complexity: O(n) - We store up to n elements in the HashMap in the worst case.
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            
            // Check if `remaining` is already in the map
            if (map.containsKey(remaining)) {
                return new int[] {i, map.get(remaining)};
            }
            
            // Store the current number and its index in the map
            map.put(nums[i], i);
        }
        
        // Return an empty array if no solution found (though the problem assumes a solution exists)
        return new int[] {};
    }
}
