class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length() ;
        return recur(expression, 0, n-1);
    }
    public List<Integer> recur(String exp, int start, int end){
        List<Integer> list = new ArrayList<>();
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
        for(int i=start; i <= end; i++){
            if(Character.isDigit(exp.charAt(i))){
                continue;
            }
            char op = exp.charAt(i);
            List<Integer> left = recur(exp,start,i-1);
            List<Integer> right = recur(exp,i+1,end);
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

        return list;
    }
}