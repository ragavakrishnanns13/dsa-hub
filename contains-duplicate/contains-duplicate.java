    /**
     * Problem Hint: Determine if there are any duplicate elements in the array.
     * Solution: We use a HashSet to track the elements we have seen so far.
     *           As we iterate through the array, if we encounter an element
     *           already in the HashSet, we know there is a duplicate and return true.
     *           If no duplicates are found by the end of the loop, return false.
     * 
     * Time Complexity: O(n) - We check each element once and HashSet operations
     *                  (add and contains) take O(1) on average.
     * Space Complexity: O(n) - In the worst case, all elements are unique, so we store
     *                   all n elements in the HashSet.
     */
     
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        } 
        return false;  
    }
}