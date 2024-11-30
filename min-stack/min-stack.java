//Amazon
/**
 * Problem: Implement a stack that supports push, pop, top, and retrieving the minimum element in O(1) time.
 * 
 * Approach:
 * - Use a single stack to store elements, along with a `mini` variable to keep track of the current minimum.
 * - Instead of storing the actual value for elements less than the current minimum, 
 *   store a transformed value (`2 * val - mini`) in the stack to encode the new minimum.
 * - This approach ensures that we can track and retrieve the minimum efficiently without using extra space.
 * 
 * Time Complexity:
 * - Push: O(1)
 * - Pop: O(1)
 * - Top: O(1)
 * - GetMin: O(1)
 * 
 * Space Complexity: O(n) - For the stack storage.
 */
class MinStack {
    private Stack<Long> st; // Stack to store elements (or transformed values).
    private Long mini;      // Tracks the current minimum element.

    /** Initialize the stack. */
    public MinStack() {
        st = new Stack<>();
        mini = Long.MAX_VALUE; // Set initial minimum to the maximum possible value.
    }

    /**
     * Push an element onto the stack.
     */
    public void push(int value) {
        Long val = Long.valueOf(value); // Convert int to Long for transformations.
        if (st.isEmpty()) {
            // If stack is empty, set this value as the minimum.
            mini = val;
            st.push(val);
        } else {
            if (val < mini) {
                // Store a transformed value if the new value is smaller than the current minimum.
                st.push(2 * val - mini);
                mini = val; // Update the minimum to the new value.
            } else {
                // Otherwise, store the actual value.
                st.push(val);
            }
        }
    }

    /**
     * Remove the top element from the stack.
     */
    public void pop() {
        if (st.isEmpty()) return; // No operation if the stack is empty.

        Long val = st.pop(); // Pop the top element.
        if (val < mini) {
            // If the popped value is less than the current minimum, 
            // retrieve the previous minimum using the transformation.
            mini = 2 * mini - val;
        }
    }

    /**
     * Retrieve the top element of the stack.
     */
    public int top() {
        Long val = st.peek();
        if (val < mini) {
            // If the stored value is a transformed value, return the current minimum.
            return mini.intValue();
        }
        return val.intValue();
    }

    /**
     * Retrieve the minimum element in the stack.
     */
    public int getMin() {
        return mini.intValue();
    }
}
