class Solution {
    public int divide(int dividend, int divisor) {
        int ans = 0;
        if(divisor==(-1) && dividend<(-1)){
             ans +=(-1)*(dividend + 1);
        }
        else{
            int q=dividend/divisor;
            int r=dividend%divisor;
             ans +=q-r/divisor;
        }
        
        return ans;
    }
}