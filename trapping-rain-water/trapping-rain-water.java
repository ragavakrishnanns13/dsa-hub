class Solution {
    public int trap(int[] height) {
        int res = 0, leftMax = 0, rightMax = 0;
        int l = 0, r = height.length-1;
        while(l<r){
            if(height[l] <= height[r]){
                if(leftMax > height[l]){
                    res += leftMax - height[l];
                }
                else{
                    leftMax = height[l];
                }
                l++;
            }
            else{
                if(rightMax > height[r]){
                    res += rightMax - height[r];
                }
                else{
                    rightMax = height[r];
                }
                r--;
            }
        }
        return res;
    }
}