class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int len = 0;
        for(int num: set){
            int count = 0;
            if(!set.contains(num-1)){
                int start = num;
                count = 1;
                while(set.contains(start+1)){
                    count+=1;
                    start+=1;
                }
            }
            len = Math.max(len, count);

        }
        return len;
    }
}