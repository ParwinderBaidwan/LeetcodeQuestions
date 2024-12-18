class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        // Create a 2D array to store results of subproblems
        int[][] dp = new int[n][amount + 1];

        for(int i=0; i<=amount; i++){
            if(i % coins[0] == 0){
                dp[0][i] = i / coins[0];
            } else{
                dp[0][i] = (int) Math.pow(10,9);
            }
        }

        for(int ind=1; ind<n; ind++){
            for(int target=0; target <= amount; target++){
                int notTake = 0 + dp[ind-1][target];
                int take = (int) Math.pow(10, 9);

                // If the current element is less than or equal to the target, calculate 'take'
                if (coins[ind] <= target)
                    take = 1 + dp[ind][target - coins[ind]];

                // Store the minimum result in the dp array
                dp[ind][target] = Math.min(notTake, take);
            }
        }

        int ans =  dp[n-1][amount];

        // If it's not possible to achieve the target sum, return -1
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;

    }
}