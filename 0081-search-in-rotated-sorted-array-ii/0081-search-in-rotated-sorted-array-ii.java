class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int s = 0;
        int e = n-1;

        while(s<=e){
            int mid = s + (e-s)/2;

            if(nums[mid] == target){
                return true;
            }

            if(nums[s] == nums[mid] && nums[mid] == nums[e]){
                s++;
                e--;
                continue;
            }

            if(nums[s] <= nums[mid]){
                if(target >= nums[s] && target < nums[mid]){
                    e = mid-1;
                } else{
                    s = mid + 1;
                }
            } else{
                if(target > nums[mid] && target <= nums[e]){
                    s = mid + 1;
                } else{
                    e = mid -1;
                }
            }
        }

        return false;
    }
}