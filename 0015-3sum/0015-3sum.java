class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for(int i=0; i<n; i++){
            Set<Integer> hashset = new HashSet<>();
            for(int j=i+1; j<n; j++){
                int third = -(nums[i] + nums[j]);

                if(hashset.contains(third)){        
                    List<Integer> temp = Arrays.asList(nums[i] ,nums[j], third);
                    temp.sort(null);
                    set.add(temp);
                }
                hashset.add(nums[j]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
}