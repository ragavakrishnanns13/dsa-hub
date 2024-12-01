//Meta
/**
 * Problem: Given a list of daily temperatures, return an array where each element indicates 
 *          how many days you would have to wait until a warmer temperature.
 *          If there is no future day with a warmer temperature, store 0 for that day.
 *
 * Approach:
 * - Use a stack to store pairs of temperatures and their indices.
 * - Traverse the temperature array:
 *   1. For each temperature, check if it is warmer than the temperature at the top of the stack.
 *   2. If so, calculate the difference in days and store it in the result array.
 *   3. Continue until the stack is empty or the current temperature is not warmer.
 *   4. Push the current temperature and index onto the stack.
 * - At the end, any indices left in the stack have no future warmer temperatures, so their result is 0.
 *
 * Time Complexity: O(n) - Each element is pushed and popped from the stack at most once.
 * Space Complexity: O(n) - Stack stores at most n elements.
 */
class Solution {
    /**
     * Computes the number of days until a warmer temperature for each day.
     * @param temp An array of daily temperatures.
     * @return An array where each element indicates how many days to wait for a warmer temperature.
     */
    public int[] dailyTemperatures(int[] temp) {
        // Initialize a stack to store pairs of temperature and their indices.
        Stack<int[]> stack = new Stack<>();
        // Result array to store the number of days to wait for a warmer temperature.
        int[] res = new int[temp.length];
        
        // Iterate through the array of temperatures.
        for (int i = 0; i < temp.length; i++) {
            int t = temp[i]; // Current temperature.
            
            // Check if the current temperature is warmer than the top of the stack.
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                // Pop the stack and calculate the difference in days.
                int[] pair = stack.pop(); // The pair contains [temperature, index].
                res[pair[1]] = i - pair[1]; // Calculate the difference in indices.
            }
            
            // Push the current temperature and its index onto the stack.
            stack.push(new int[]{t, i});
        }
        
        // Any remaining indices in the stack have no future warmer temperature.
        // These values are already 0 by default in the result array.
        
        return res; // Return the result array.
    }
}
