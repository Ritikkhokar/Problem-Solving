public class BuyandSellStock {
    public static int stockBuyAndSell(int n, int[] prices) {
        // code here
        int buy = 0;
        int sell = 0;
        int sum = 0;
        for(int i=1;i<n;i++){
            if(prices[i]>= prices[i-1]){
                sell++;
            }else{
                if(buy != sell){
                   sum += prices[sell] - prices[buy];
                }
                buy = sell = i;
            }
        }
        
        if(buy != sell){
            sum += prices[sell] - prices[buy];
           }
           
           return sum;
    }
}
