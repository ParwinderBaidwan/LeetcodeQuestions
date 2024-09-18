class Solution {
    public String largestNumber(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                String s1 = String.valueOf(nums[i]);
                String s2 = String.valueOf(nums[j]);
                String temp1 = s1 + s2;
                String temp2 = s2 + s1;
                if (temp2.compareTo(temp1) > 0) {
                    int swap = nums[i];
                    nums[i] = nums[j];
                    nums[j] = swap;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (int num : nums) {
            res.append(num);
        }

        // Edge case: if the largest number is "0", return "0"
        if (res.charAt(0) == '0') {
            return "0";
        }

        return res.toString();
    }
}
