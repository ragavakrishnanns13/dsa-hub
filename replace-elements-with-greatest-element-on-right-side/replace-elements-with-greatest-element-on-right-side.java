class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int currentMax = Integer.MIN_VALUE;
        for(int i=n-2;i>=0;i--){
            currentMax = Math.max(arr[i+1], currentMax);
            res[i] = currentMax;
        }
        res[n-1] = -1;
        return res;
    }
}