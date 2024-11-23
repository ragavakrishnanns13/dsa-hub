class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        int prefix = res[0];
        for(int i=1;i<nums.length;i++){
            prefix = nums[i-1];
            res[i] = res[i-1] * prefix;

        }
        int postfix = 1;
        for(int i=nums.length-2;i>=0;i--){
            postfix *= nums[i+1];
            res[i] *= postfix;
        }
        return res;
    }
}