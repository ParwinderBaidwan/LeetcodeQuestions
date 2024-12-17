class Solution {
    public int climbStairs(int n) {
        
        // return countPath(n, new int [n+1]);
        return countPathTab(n);
    }

// using Memoization
    public int countPath(int n, int []dp){
        if(n == 0){
            return 1;
        }else if (n < 0){
            return 0;
        }

        if(dp[n] > 0){
            return dp[n];
        }

        
        int ways = countPath(n-1, dp) + countPath(n-2, dp);
        dp[n] = ways;

        return ways; 
    }

// using Tabulation
    public int countPathTab(int n){
        int dp[] = new int[n+1];

        dp[0] = 1;
        for(int i=1; i<=n ; i++){
            if(i==1){
                dp[i] = dp[i-1];
            }
            else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }
}