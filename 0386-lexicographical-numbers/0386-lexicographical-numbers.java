class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1; i<10; i++){
            if(i>n) break;
            dfs(i, n, res);
        }
        return res;
    }
    public void dfs(int currNum, int target, List<Integer> res){
        if(currNum > target){
            return;
        }

        res.add(currNum);
        for(int i=0; i<10; i++){
            if(currNum*10 + i > target) break;
            dfs(currNum*10+i, target, res);
        }
    }
}