import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueOfStacks {
    private Queue<Stack<Integer>> queueOfStacks;

    public QueueOfStacks() {
        queueOfStacks = new LinkedList<>();
    }

    public void addStack(Stack<Integer> stack) {
        queueOfStacks.offer(stack);
    }

    public QueueOfStacks getTranspose() {
        QueueOfStacks transposeQueue = new QueueOfStacks();

        int size = queueOfStacks.size();
        Stack<Integer>[] columnStacks = new Stack[size];
        for (int i = 0; i < size; i++) {
            columnStacks[i] = new Stack<>();
        }

        for (Stack<Integer> stack : queueOfStacks) {
            int stackSize = stack.size();
            for (int i = 0; i < stackSize; i++) {
                columnStacks[i].push(stack.pop());
            }
        }

        for (int i = 0; i < size; i++) {
            transposeQueue.addStack(columnStacks[i]);
        }

        return transposeQueue;
    }

    public void printStructure() {
        for (Stack<Integer> stack : queueOfStacks) {
            for (Integer element : stack) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        QueueOfStacks queueOfStacks = new QueueOfStacks();

        // Creamos y agregamos pilas a la cola de pilas
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        Stack<Integer> stack2 = new Stack<>();
        stack2.push(4);
        stack2.push(5);
        stack2.push(6);

        Stack<Integer> stack3 = new Stack<>();
        stack3.push(7);
        stack3.push(8);
        stack3.push(9);

        queueOfStacks.addStack(stack1);
        queueOfStacks.addStack(stack2);
        queueOfStacks.addStack(stack3);

        System.out.println("Estructura original:");
        queueOfStacks.printStructure();

        QueueOfStacks transposeQueue = queueOfStacks.getTranspose();
        System.out.println("Traspuesta de la estructura QueueOfStacks:");
        transposeQueue.printStructure();
    }
}

// Calculo complejidad computacion:

//  la complejidad computacional del código es O(N*M) en la mayoría de los casos
//  donde N es el número de pilas en la cola y M es el tamaño de cada pila.
