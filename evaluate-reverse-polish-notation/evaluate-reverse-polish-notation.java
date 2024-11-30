//Amazon
/**
 * Problem: Evaluate the value of an arithmetic expression in Reverse Polish Notation (RPN).
 *
 * Reverse Polish Notation (RPN):
 * - Operators (+, -, *, /) follow their operands.
 * - Example: The expression "3 + 4" in RPN is "3 4 +".
 *
 * Approach:
 * - Use a stack to evaluate the expression.
 * - Traverse the tokens:
 *   1. If the token is an operand (number), push it onto the stack.
 *   2. If the token is an operator (+, -, *, /):
 *      - Pop two operands from the stack.
 *      - Perform the operation.
 *      - Push the result back onto the stack.
 * - At the end, the stack contains the final result.
 *
 * Assumptions:
 * - The input is always valid.
 * - Division is integer division, truncating toward zero.
 *
 * Time Complexity: O(n) - Each token is processed once.
 * Space Complexity: O(n) - Stack space to store numbers.
 */
public class Solution {
    /**
     * Evaluates the value of an RPN expression.
     * @param tokens The RPN expression represented as an array of strings.
     * @return The evaluated result as an integer.
     */
    public int evalRPN(String[] tokens) {
        // Initialize a stack to store operands.
        Stack<Integer> S = new Stack<>();
        
        // Iterate through each token in the RPN expression.
        for (String s : tokens) {
            // Check for operators.
            if (s.equals("+")) {
                // Pop two operands, perform addition, and push the result.
                S.add(S.pop() + S.pop());
            } 
            else if (s.equals("/")) {
                // Pop two operands, perform division (second popped value is the divisor), and push the result.
                int b = S.pop();
                int a = S.pop();
                S.add(a / b);
            } 
            else if (s.equals("*")) {
                // Pop two operands, perform multiplication, and push the result.
                S.add(S.pop() * S.pop());
            } 
            else if (s.equals("-")) {
                // Pop two operands, perform subtraction (second popped value is subtracted), and push the result.
                int b = S.pop();
                int a = S.pop();
                S.add(a - b);
            } 
            else {
                // If the token is a number, convert it to an integer and push it onto the stack.
                S.add(Integer.parseInt(s));
            }
        }
        
        // At the end, the stack contains the result of the RPN expression.
        return S.pop();
    }
}
