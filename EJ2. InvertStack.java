import java.util.Stack;

public class StackUtils {
    public static <T> void reverseStack(Stack<T> stack) {
        Stack<T> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Stack original: " + stack);

        reverseStack(stack);

        System.out.println("Stack invertido: " + stack);
    }
}
