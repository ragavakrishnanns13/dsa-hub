class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int currentPrice : prices){
            minPrice = Math.min(currentPrice, minPrice);
            maxProfit = Math.max(currentPrice - minPrice, maxProfit);
        }
        return maxProfit;
    }
}