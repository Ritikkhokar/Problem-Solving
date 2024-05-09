class FriendsPairing
{
   static int mod = 1000000007;
    public long countFriendsPairings(int n) 
    { 
       //code here
       Long[] dp = new Long[n+1];
      return tabu(n, dp);
    }
    
    public static long tabu(int n, Long[] dp){
       dp[0] = 1L;
       dp[1] = 1L;
       
       for(int i=2;i<n+1;i++){
           dp[i] = (dp[i-1]%mod + (i-1)*dp[i-2]%mod)%mod;
       }
       return dp[n];
    }
}