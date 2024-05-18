class SellStockTwice {
    public static int maxProfit(int n, int[] price) {
        // code here
        int[] firstStock = new int[n];
        int[] secondStock = new int[n];
        
        firstStock[0] = 0;
        secondStock[0] = 0;
        int buyMin = price[0];
        for(int i=1;i<n;i++){
           if(price[i]< buyMin){
               firstStock[i] = firstStock[i-1];
               buyMin = price[i];
           }else{
               firstStock[i] = Math.max(firstStock[i-1], price[i] - buyMin);
           } 
        }
        
        int sellMax = price[n-1];
        for(int i=n-2; i>=0; i--){
            if(sellMax<price[i]){
                secondStock[i] = secondStock[i+1];
                sellMax = price[i];
            }else{
                secondStock[i] = Math.max(secondStock[i+1], sellMax - price[i]);
            }
        }
        int maxProfit = 0;
        for(int i =0; i<n;i++){
           maxProfit = Math.max(maxProfit, firstStock[i] + secondStock[i]); 
        }
        
        return maxProfit;
    }
}