class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length ; i++){
            int sellingPrice = prices[i];
            if(buyPrice < sellingPrice){
                int profit = sellingPrice - buyPrice;
                maxProfit = Math.max(maxProfit , profit);
            }else{
                buyPrice = sellingPrice;
            }
        }
        return maxProfit;
        
    }
}