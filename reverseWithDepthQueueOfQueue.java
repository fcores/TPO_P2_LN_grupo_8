import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueOfQueueImpl<T> implements QueueOfQueue<T> {
    private Queue<Queue<T>> queueOfQueues;

    public QueueOfQueueImpl() {
        queueOfQueues = new LinkedList<>();
    }

    // Métodos de la clase QueueOfQueueImpl

    public QueueOfQueue<T> reverseWithDepth() {
        QueueOfQueue<T> reversedQueueOfQueue = new QueueOfQueueImpl<>();

        Stack<Queue<T>> stack = new Stack<>();

        for (Queue<T> queue : queueOfQueues) {
            Queue<T> reversedQueue = new LinkedList<>();

            while (!queue.isEmpty()) {
                reversedQueue.offer(queue.poll());
            }

            stack.push(reversedQueue);
        }

        while (!stack.isEmpty()) {
            reversedQueueOfQueue.enqueue(stack.pop());
        }

        return reversedQueueOfQueue;
    }

    public static void main(String[] args) {
        QueueOfQueue<Integer> queueOfQueue = new QueueOfQueueImpl<>();

        Queue<Integer> queue1 = new LinkedList<>();
        queue1.offer(1);
        queue1.offer(2);
        queue1.offer(3);

        Queue<Integer> queue2 = new LinkedList<>();
        queue2.offer(4);
        queue2.offer(5);
        queue2.offer(6);

        Queue<Integer> queue3 = new LinkedList<>();
        queue3.offer(7);
        queue3.offer(8);
        queue3.offer(9);

        queueOfQueue.enqueue(queue1);
        queueOfQueue.enqueue(queue2);
        queueOfQueue.enqueue(queue3);

        QueueOfQueue<Integer> reversedQueueOfQueue = queueOfQueue.reverseWithDepth();

        System.out.println("Reversed QueueOfQueue: ");
        reversedQueueOfQueue.printStructure();
    }
}

//  El tamaño de las colas de pilas es n, por lo que iteraremos n veces en el bucle for.
//  En cada iteración del bucle for, realizamos operaciones en las pilas stack1 y stack2, que tienen un tamaño máximo de n elementos.
//  En total, el método matrixSum tiene una complejidad de O(n^2), donde n es el tamaño de las colas de pilas.
