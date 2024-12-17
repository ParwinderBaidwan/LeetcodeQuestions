class Solution {
    public int climbStairs(int n) {
        return countPath(n, new int[n+1]);
    }

    public int countPath(int n, int[] qb){
        if(n == 0){
            return 1;
        } else if(n < 0){
            return 0;
        }

        if(qb[n] != 0){
            return qb[n];
        }

        int path1 = countPath(n-1, qb);
        int path2 = countPath(n-2, qb);
        int path = path1 + path2;

        qb[n] = path;

        return path;
    }
}