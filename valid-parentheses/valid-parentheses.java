//Meta

/**
 * Problem: Check if a string containing parentheses is valid.
 * 
 * A string is considered valid if:
 * 1. Open brackets are closed by the same type of brackets.
 * 2. Open brackets are closed in the correct order.
 *
 * Approach:
 * - Use a stack to match opening and closing brackets.
 * - Push opening brackets into the stack.
 * - For each closing bracket, check if it matches the top of the stack.
 * - If it matches, pop the top element from the stack.
 * - If not, return false (invalid string).
 * - At the end, ensure the stack is empty for the string to be valid.
 * 
 * Time Complexity: O(n) - We traverse the string once.
 * Space Complexity: O(n) - In the worst case, all brackets are open, requiring n stack space.
 * 
 */
class Solution{
    public boolean isValid(String s) {
    // Initialize a stack to keep track of opening brackets.
    Stack<Character> st = new Stack<>();
    
    // Iterate through each character in the string.
    for (char c : s.toCharArray()) {
        // Push opening brackets onto the stack.
        if (c == '(' || c == '{' || c == '[') {
            st.push(c);
        } 
        // Handle closing brackets.
        else {
            // If the stack is empty, there's no matching opening bracket.
            if (st.isEmpty()) {
                return false;
            }
            
            // Pop the top of the stack and check if it matches the current closing bracket.
            char top = st.pop();
            if ((c == ')' && top != '(') || 
                (c == '}' && top != '{') || 
                (c == ']' && top != '[')) {
                return false;
            }
        }
    }
    
    // If the stack is empty, all brackets matched correctly.
    return st.isEmpty();
}

}