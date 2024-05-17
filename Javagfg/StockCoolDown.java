class StockCoolDown{
    public long maximumProfit(long prices[], int N){
        //Code here
        long buyState =0 - prices[0];
        long sellState = 0;
        long coolDownState = 0;
        
        for(int i=1;i<N;i++){
           long tempBuyState = Math.max(buyState, coolDownState - prices[i]);
           long tempSellState = Math.max(sellState, buyState + prices[i]);
           long tempCoolDownState = Math.max(coolDownState, sellState);
           
           buyState = tempBuyState;
           sellState = tempSellState;
           coolDownState = tempCoolDownState;
        }
        return sellState;
    }
}