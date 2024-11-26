//Google
class Solution {
    /**
     * Problem: Find the maximum profit that can be achieved by buying and selling a stock once.
     * Approach: Iterate through the array while keeping track of the minimum price seen so far 
     *           and the maximum profit that can be achieved by selling at the current price.
     * 
     * Time Complexity: O(n) - Single pass through the array.
     * Space Complexity: O(1) - Constant extra space used.
     */
    public int maxProfit(int[] prices) {
        // Initialize the maximum profit to 0 (no transactions means no profit).
        int maxProfit = 0;

        // Initialize the minimum price to the maximum possible integer value.
        int minPrice = Integer.MAX_VALUE;

        // Iterate through each price in the array.
        for (int currentPrice : prices) {
            // Update the minimum price if the current price is lower than the current minimum.
            minPrice = Math.min(currentPrice, minPrice);

            // Calculate the profit if the stock is sold at the current price,
            // and update the maximum profit if this profit is greater.
            maxProfit = Math.max(currentPrice - minPrice, maxProfit);
        }

        // Return the maximum profit found.
        return maxProfit;
    }
}
