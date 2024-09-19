class Solution {
    // TC : O(N*2^N)
    // SC : O(N^2 * 2^N) N^2 for dp array
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length() ;
        List<Integer> dp[][] = new ArrayList[n][n];
        return recur(expression, 0, n-1, dp);
    }

    public List<Integer> recur(String exp, int start, int end, List<Integer> dp[][]){
        List<Integer> list = new ArrayList<>();

        if(dp[start][end] != null){
            return dp[start][end];
        }
        // base case : single digit
        if(start == end){
            int num = exp.charAt(start) - '0';
            list.add(num);
            return list;
        }
        // base case : double digit
        if(end-start == 1 && Character.isDigit(exp.charAt(start))){
            int num1 = Integer.parseInt(exp.substring(start, end+1));
            list.add(num1);
            return list;
        }
        // split
        // N
        for(int i=start; i <= end; i++){
            if(Character.isDigit(exp.charAt(i))){
                continue;
            }
            char op = exp.charAt(i);
            // 2^N
            List<Integer> left = recur(exp,start,i-1, dp);
            List<Integer> right = recur(exp,i+1,end, dp);
            for(int l : left){
                for(int r : right){
                    if(op == '*'){
                        list.add(l*r);
                    }
                    else if(op == '+'){
                        list.add(l+r);
                    }
                    else{
                        list.add(l-r);
                    }
                }
            }
        }

        dp[start][end] = list;
        return list;
    }
}