class Solution {
    public int divide(int dividend, int divisor) {
        int ans = 0;
        if(divisor==(-1) && dividend<(-1)){
             ans +=(-1)*(dividend + 1);
        }
        else{
            ans+=dividend/divisor;
            // int r=dividend%divisor;
            //  ans +=q-r/divisor;
        }
        
        return ans;
    }
}

// edge case
// dividend =
// -2147483648
// divisor =
// -1