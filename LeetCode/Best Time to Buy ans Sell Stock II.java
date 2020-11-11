class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = 0, sell = 0;
        
        for(int i = 0; i < prices.length; i++){
            // Check for buying price
            for( buy = i; buy < prices.length-1; buy++){
                if( prices[buy+1] > prices[buy])
                    break;
            }
            
            // Find sell date
            for(sell = buy + 1; sell < prices.length-1; sell++ ){
                if( prices[sell+1] < prices[sell]){
                    profit += prices[sell] - prices[buy];
                    i = sell;
                    break;
                }
            }
            
            // Reached last day without selling, compare final price
            if( (sell == prices.length-1) && (prices[sell] > prices[buy]) ) {
                profit += prices[sell] - prices[buy];
                break;
            }
        }
        
        return profit;
    }
}