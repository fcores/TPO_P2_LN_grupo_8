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

// Calculo complejidad computacional
//Dado que cada pila se recorre solo una vez y se accede a un elemento específico en tiempo 
//constante (ya que las pilas son implementadas con la clase Stack), el tiempo de ejecución 
//total es proporcional al número total de elementos en todas las pilas
//Por lo tanto, la complejidad computacional del método calculateTrace es O(N), 
//donde N es la suma de los tamaños de todas las pilas en la cola de pilas.
