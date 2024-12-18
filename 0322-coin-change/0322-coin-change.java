class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        // Create a 2D array to store results of subproblems
        int[][] dp = new int[n][amount + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (int row[] : dp)
            Arrays.fill(row, -1);

        int ans =  minElements(coins, n-1, amount, dp );

        // If it's not possible to achieve the target sum, return -1
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }

    public int minElements(int[] coins, int index, int amount, int[][]dp){
        //base case
        if(index == 0){
            if(amount % coins[0] == 0){
                return amount / coins[0];
            } else{
                return (int) Math.pow(10,9);
            }
        }

        // If the result for this subproblem has already been calculated, return it
        if (dp[index][amount] != -1)
            return dp[index][amount];

        int notTaken = 0 + minElements(coins, index-1, amount, dp);

        // Initialize the minimum number of elements needed taking the current element
        int taken = (int)Math.pow(10,9);
        if(coins[index] <= amount){
            taken = 1 + minElements(coins, index, amount - coins[index], dp);
        }

        return dp[index][amount] = Math.min(notTaken, taken);
    }
}