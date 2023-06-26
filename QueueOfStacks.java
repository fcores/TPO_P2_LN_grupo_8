import java.util.Queue;
import java.util.Stack;

public class QueueOfStacks {
    private Queue<Stack<Integer>> queueOfStacks;

    // Constructor y otros métodos de la clase QueueOfStacks

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

        // Agrega tus pilas a la cola de pilas aquí...

        int trace = queueOfStacks.calculateTrace();
        System.out.println("La traza de la estructura QueueOfStacks es: " + trace);
    }
}
