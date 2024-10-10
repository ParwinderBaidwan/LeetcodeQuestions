class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int max = 0;

        // storing the indices in decresing order in stack
        for(int i=0; i<nums.length; i++){
            if(st.isEmpty() || nums[st.peek()] > nums[i]){
                st.push(i);
            }
        }

        // traverse from end to get the max width
        for(int j=nums.length - 1; j>=0; j--){
            while(!st.isEmpty() && nums[st.peek()] <= nums[j]){
                max = Math.max(max, j - st.pop());
            }
        }

        return max;
    }
}


// TLE
        // int n = nums.length;
        // int max = Integer.MIN_VALUE;
        // for(int i=0; i<n; i++){
        //     for(int j=i+1; j<n; j++){
        //         if(nums[i] <= nums[j]){
        //             max = Math.max(max, j-i);
        //         }
        //     }
        // }

        // if(max == Integer.MIN_VALUE ){
        //     return 0;
        // }
        // return max;