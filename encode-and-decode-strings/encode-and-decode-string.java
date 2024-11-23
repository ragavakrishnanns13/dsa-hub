// Facebook
class Solution {
    /**
     * Problem Hint: Given a list of strings, encode the list into a single string such 
     *               that it can be decoded back into the original list of strings.
     * Solution: Use a delimiter-based approach. Each string is prefixed with its length 
     *           followed by a delimiter (e.g., '#'). During decoding, the length 
     *           indicates where each string starts and ends in the encoded string.
     * 
     * Time Complexity:
     * - Encoding: O(n), where n is the total number of characters in all strings.
     * - Decoding: O(n), for traversing the encoded string to reconstruct the original list.
     * 
     * Space Complexity:
     * - Encoding: O(n), for building the encoded string.
     * - Decoding: O(n), for storing the decoded list of strings.
     */
    public class Solution {

        public String encode(List<String> strs) {
            // Initialize a StringBuilder to store the encoded string
            StringBuilder res = new StringBuilder();
            
            // Iterate through each string in the input list
            for (String s : strs) {
                // Append the length of the string, a delimiter ('#'), and the string itself
                res.append(s.length()).append('#').append(s);
            }
            
            // Return the fully encoded string
            return res.toString();
        }

        public List<String> decode(String str) {
            // Initialize a list to store the decoded strings
            List<String> res = new ArrayList<>();
            
            // Pointer to traverse the encoded string
            int i = 0;
            
            // Loop until the end of the encoded string
            while (i < str.length()) {
                int j = i;
                
                // Locate the delimiter '#' to extract the string length
                while (str.charAt(j) != '#') {
                    j++;
                }
                
                // Extract the string length from the substring before '#'
                int length = Integer.parseInt(str.substring(i, j));
                
                // Update the pointer to start of the actual string
                i = j + 1;
                
                // Extract the string using the calculated length
                j = i + length;
                res.add(str.substring(i, j));
                
                // Move the pointer to the next encoded string
                i = j;
            }
            
            // Return the decoded list of strings
            return res;
        }
    }
}
