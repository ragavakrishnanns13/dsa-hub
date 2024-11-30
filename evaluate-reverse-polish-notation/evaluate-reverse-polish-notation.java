class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            // Check if the token is an operator
            if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("/") && !tokens[i].equals("*")) {
                st.push(Integer.parseInt(tokens[i])); // Push numbers onto the stack
            } else {
                // Pop two elements for the operation
                int a = st.pop();
                int b = st.pop();
                switch (tokens[i]) {
                    case "+":
                        st.push(b + a); // Note: b is popped first, so b is the left operand
                        break;
                    case "-":
                        st.push(b - a);
                        break;
                    case "/":
                        st.push(b / a);
                        break;
                    case "*":
                        st.push(b * a);
                        break;
                }
            }
        }
        return st.peek(); // Return the top element of the stack
    }
}
