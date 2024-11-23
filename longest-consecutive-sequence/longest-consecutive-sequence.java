// Google
class Solution {
    /**
     * Problem Hint: Find the length of the longest consecutive sequence of numbers
     *               in an unsorted array of integers. The sequence must be consecutive 
     *               but does not need to be contiguous in the array.
     * Solution: Use a HashSet to efficiently check for the presence of elements and 
     *           identify the start of a sequence. For each sequence, determine its length 
     *           by iteratively checking consecutive numbers.
     * 
     * Time Complexity: O(n) - Each number is processed once (insertion in the set and 
     *                  traversal of the sequence).
     * Space Complexity: O(n) - Space required for the HashSet.
     */
    public int longestConsecutive(int[] nums) {
        //Add all numbers to a HashSet for O(1) lookups
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        //Initialize the variable to store the longest sequence length
        int len = 0;

        //Iterate through the set to find the start of each sequence
        for (int num : set) {
            // Check if the current number is the start of a sequence
            if (!set.contains(num - 1)) { // If `num - 1` is not in the set, `num` starts a sequence
                int count = 1; // Start counting the sequence length
                int start = num;

                //Count the length of the sequence
                while (set.contains(start + 1)) { // Check if the next consecutive number exists
                    start += 1; // Move to the next number in the sequence
                    count += 1; // Increment the sequence length
                }

                //Update the maximum sequence length found so far
                len = Math.max(len, count);
            }
        }

        //Return the length of the longest consecutive sequence
        return len;
    }
}
