class Solution {
    public int findKthNumber(int n, int k) {
        int curNum = 1;
        k--;  // The first number in lexicographical order is '1', so we decrement k by 1.

        while (k > 0) {
            int steps = countSteps(n, curNum, curNum + 1);
            
            if (steps <= k) {
                // If there are fewer than or equal to k numbers in this prefix, move to the next prefix
                curNum += 1;
                k -= steps;
            } else {
                // Otherwise, go deeper into the current prefix by multiplying by 10
                curNum *= 10;
                k -= 1;  // We are using one number (the current prefix number itself)
            }
        }
        
        return curNum;
    }

    // Helper function to count the steps/numbers between two bounds in lexicographical order
    private int countSteps(int n, long first, long second) {
        int steps = 0;
        while (first <= n) {
            steps += Math.min(n + 1, second) - first;
            first *= 10;
            second *= 10;
        }
        return steps;
    }
}
