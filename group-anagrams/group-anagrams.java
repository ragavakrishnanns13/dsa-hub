//Amazon
class Solution {
    /**
     * Problem Hint: Given an array of strings, group anagrams together.
     * Solution: For each string, sort its characters to form a "canonical" key that 
     *           represents the anagram group. Use this sorted key in a HashMap to 
     *           group anagrams. If two strings are anagrams, they will have the same
     *           sorted key and will be grouped together in the map.
     * 
     * Time Complexity: O(n * k log k) - We iterate over each string in `strs` (n strings),
     *                  and for each string of length k, we sort its characters (O(k log k)).
     * Space Complexity: O(n * k) - The HashMap stores up to n entries, with each entry 
     *                   containing strings of average length k.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Convert string to char array and sort it to form the canonical key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            // Add the string to the appropriate anagram group in the map
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        
        // Return the values of the map as a list of anagram groups
        return new ArrayList<>(map.values());
    }
}