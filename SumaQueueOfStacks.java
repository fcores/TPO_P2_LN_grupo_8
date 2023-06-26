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

    public static QueueOfStacks matrixSum(QueueOfStacks queue1, QueueOfStacks queue2) {
        QueueOfStacks sumQueue = new QueueOfStacks();

        if (queue1.queueOfStacks.size() != queue2.queueOfStacks.size()) {
            throw new IllegalArgumentException("Las estructuras QueueOfStacks no tienen el mismo tamaño");
        }

        int size = queue1.queueOfStacks.size();

        for (int i = 0; i < size; i++) {
            Stack<Integer> stack1 = queue1.queueOfStacks.poll();
            Stack<Integer> stack2 = queue2.queueOfStacks.poll();

            Stack<Integer> sumStack = new Stack<>();
            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                int element1 = stack1.pop();
                int element2 = stack2.pop();
                int sum = element1 + element2;
                sumStack.push(sum);
            }

            // Asegurarse de mantener el orden correcto en las pilas
            while (!stack1.isEmpty()) {
                sumStack.push(stack1.pop());
            }
            while (!stack2.isEmpty()) {
                sumStack.push(stack2.pop());
            }

            sumQueue.queueOfStacks.offer(sumStack);
        }

        return sumQueue;
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
        QueueOfStacks queue1 = new QueueOfStacks();
        QueueOfStacks queue2 = new QueueOfStacks();

        // Crear y agregar pilas a la cola de pilas de queue1
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

        queue1.addStack(stack1);
        queue1.addStack(stack2);
        queue1.addStack(stack3);

        // Crear y agregar pilas a la cola de pilas de queue2
        Stack<Integer> stack4 = new Stack<>();
        stack4.push(10);
        stack4.push(11);
        stack4.push(12);

        Stack<Integer> stack5 = new Stack<>();
        stack5.push(13);
        stack5.push(14);
        stack5.push(15);

        Stack<Integer> stack6 = new Stack<>();
        stack6.push(16);
        stack6.push(17);
        stack6.push(18);

        queue2.addStack(stack4);
        queue2.addStack(stack5);
        queue2.addStack(stack6);

        System.out.println("Estructura original 1:");
        queue1.printStructure();


