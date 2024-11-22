//Amazon
class Solution {
    /**
     * Problem Hint: Given an array of integers `nums`, return the k most frequent elements.
     * Solution: Use a HashMap to count the frequency of each element. Then, use a 
     *           bucket sort approach to group elements by their frequency. Finally,
     *           traverse the buckets in reverse order (highest frequency first) to 
     *           collect the top k frequent elements.
     * 
     * Time Complexity: O(n) - Counting frequencies takes O(n), creating the frequency buckets 
     *                  also takes O(n), and iterating over the buckets takes O(n).
     * Space Complexity: O(n) - Space is used for the frequency map and the frequency buckets.
     */
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each number
        // Create a HashMap to store numbers and their frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create an array of lists (buckets) to store numbers by their frequency
        // The array size is nums.length + 1 because the maximum frequency a number
        // can have is equal to the length of the array
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // Step 3: Fill the frequency buckets
        // For each entry in the frequency map, add the number to the corresponding bucket
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();
            freq[frequency].add(number);
        }

        // Step 4: Collect the top k frequent elements
        // Create a result array to store the top k elements
        int[] res = new int[k];
        int index = 0;

        // Traverse the buckets in reverse order (from highest frequency to lowest)
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n; // Add the number to the result array
                if (index == k) { // Stop once we've collected k elements
                    return res;
                }
            }
        }

        // Return the result array
        return res;
    }
}
