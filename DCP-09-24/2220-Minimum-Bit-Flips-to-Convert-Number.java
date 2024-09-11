class Solution {
    public int minBitFlips(int start, int goal) {
        // TC : O(N);
        // SC : O(1)
        int xor = start ^ goal;
        int count = 0;
        while(xor > 0){
            int temp = xor & 1;
            count += temp;
            xor = xor >> 1;
        }

        return count;
    }
}