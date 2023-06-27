import java.util.Queue;
import java.util.Stack;

public class QueueOfStacks {
    private Queue<Stack<Integer>> queueOfStacks;

    // el constructor y métodos de la clase QueueOfStacks

    public int calculateTrace() {
        int trace = 0;
        int currentIndex = 0;

        for (Stack<Integer> stack : queueOfStacks) {
            if (!stack.isEmpty()) {
                trace += stack.get(currentIndex);
                currentIndex++;
            }
        }

        return trace;
    }

    public static void main(String[] args) {
        QueueOfStacks queueOfStacks = new QueueOfStacks();
        
        int trace = queueOfStacks.calculateTrace();
        System.out.println("La traza de la estructura QueueOfStacks es: " + trace);
    }
}
