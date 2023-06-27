import java.util.LinkedList;
import java.util.Queue;

public class QueueOfQueueImpl<T> implements QueueOfQueue<T> {
    private Queue<Queue<T>> queueOfQueues;

    public QueueOfQueueImpl() {
        queueOfQueues = new LinkedList<>();
    }

    // métodos de la clase QueueOfQueueImpl

    public Queue<T> flat() {
        Queue<T> flatQueue = new LinkedList<>();

        for (Queue<T> queue : queueOfQueues) {
            for (T element : queue) {
                flatQueue.offer(element);
            }
        }

        return flatQueue;
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

        Queue<Integer> flatQueue = queueOfQueue.flat();

        System.out.println("Flat Queue: " + flatQueue);
    }
}
