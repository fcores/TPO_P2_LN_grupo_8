import java.util.LinkedList;
import java.util.Queue;

public interface QueueOfQueue<T> {
    void enqueue(T element);
    T dequeue();
    boolean isEmpty();
    int size();
    void concatenate(QueueOfQueue<T>... queues);
}

public class QueueOfQueueImpl<T> implements QueueOfQueue<T> {
    private Queue<Queue<T>> queueOfQueues;

    public QueueOfQueueImpl() {
        queueOfQueues = new LinkedList<>();
    }

    @Override
    public void enqueue(T element) {
        if (queueOfQueues.isEmpty() || !queueOfQueues.peek().isEmpty()) {
            Queue<T> newQueue = new LinkedList<>();
            newQueue.offer(element);
            queueOfQueues.offer(newQueue);
        } else {
            queueOfQueues.peek().offer(element);
        }
    }

    @Override
    public T dequeue() {
        if (queueOfQueues.isEmpty()) {
            throw new IllegalStateException("The QueueOfQueue is empty");
        }

        Queue<T> currentQueue = queueOfQueues.peek();
        T element = currentQueue.poll();

        if (currentQueue.isEmpty()) {
            queueOfQueues.poll();
        }

        return element;
    }

    @Override
    public boolean isEmpty() {
        return queueOfQueues.isEmpty();
    }

    @Override
    public int size() {
        int totalSize = 0;
        for (Queue<T> queue : queueOfQueues) {
            totalSize += queue.size();
        }
        return totalSize;
    }

    @Override
    public void concatenate(QueueOfQueue<T>... queues) {
        for (QueueOfQueue<T> queue : queues) {
            while (!queue.isEmpty()) {
                enqueue(queue.dequeue());
            }
        }
    }

    public static void main(String[] args) {
        QueueOfQueue<Integer> queueOfQueue = new QueueOfQueueImpl<>();

        QueueOfQueue<Integer> queue1 = new QueueOfQueueImpl<>();
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);

        QueueOfQueue<Integer> queue2 = new QueueOfQueueImpl<>();
        queue2.enqueue(4);
        queue2.enqueue(5);

        QueueOfQueue<Integer> queue3 = new QueueOfQueueImpl<>();
        queue3.enqueue(6);
        queue3.enqueue(7);
        queue3.enqueue(8);
        queue3.enqueue(9);

        queueOfQueue.concatenate(queue1, queue2, queue3);

        while (!queueOfQueue.isEmpty()) {
            System.out.println(queueOfQueue.dequeue());
        }
    }
}
