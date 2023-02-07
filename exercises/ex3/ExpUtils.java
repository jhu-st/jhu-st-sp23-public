import java.util.Stack;

public class ExpUtils {
    /**
     * This method decides if an expression comprised of '(', ')', '[', ']', '{', and '}'
     * is valid or not. An input expression is valid if:
     * 1. Open brackets must be closed by the same type of brackets.
     * 2. Open brackets must be closed in the correct order.
     * 3. empty strings are considered valid
     * @param input the input expression given as a string
     * @return true if the expression is valid, false otherwise.
     */
    public static boolean validBrackets(String input) {
        if (input.isEmpty()) {
            return true;
        }
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                char peekChar = stack.peek();
                if ((current == ')' && peekChar != '(')
                        || (current == '}' && peekChar != '{')
                        || (current == ']' && peekChar != '[')) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return true;
    }

}
