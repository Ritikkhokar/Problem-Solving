public class StockWithFee {
    public long maximumProfit(long prices[], int n, int fee) {
        // Code here
        long buyState = 0-prices[0];
        long sellState = 0;
        
        for(int i=1;i<n;i++){
            buyState = Math.max(buyState, sellState - prices[i]);
            sellState = Math.max(sellState, buyState + prices[i] - fee);
        }
        
        return sellState;
    }
}
