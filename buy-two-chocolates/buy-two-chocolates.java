class Solution {
    public int buyChoco(int[] prices, int money) {
        
        Arrays.sort(prices);
        int minSum = prices[0] + prices[1];
        if(minSum<=money){
            return money - minSum;
        }
        else return money;
    }
}