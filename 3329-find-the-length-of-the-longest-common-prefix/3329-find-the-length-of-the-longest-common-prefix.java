class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr1.length; i++){
            int num = arr1[i];
            while(num > 0){
                if(!set.contains(num)){
                    set.add(num);    
                }
                num /= 10;
            }
        }

        // for(Integer ele : set){
        //     System.out.print(ele + " ");
        // }
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<arr2.length; i++){
            int num = arr2[i];
            while(num > 0){
                if(set.contains(num)){
                    int length = String.valueOf(num).length();
                    maxi = Math.max(maxi, length);
                }
                num /= 10;
            }
        }

        if(maxi < 0){
            return 0;
        }
        return maxi;
    }
}