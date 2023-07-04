import java.util.LinkedList;
import java.util.Queue;

public class QueueOfQueue<E> {
    private Queue<Queue<E>> queueOfQueues;

    public QueueOfQueue() {
        queueOfQueues = new LinkedList<>();
    }

    public void addQueue(Queue<E> queue) {
        queueOfQueues.offer(queue);
    }

    public Queue<E> getQueue() {
        return queueOfQueues.poll();
    }

    public boolean isEmpty() {
        return queueOfQueues.isEmpty();
    }

    public int size() {
        return queueOfQueues.size();
    }

    public static <E> Queue<E> flat(QueueOfQueue<E> queueOfQueue) {
        Queue<E> flatQueue = new LinkedList<>();

        while (!queueOfQueue.isEmpty()) {
            Queue<E> queue = queueOfQueue.getQueue();
            while (!queue.isEmpty()) {
                flatQueue.offer(queue.poll());
            }
        }

        return flatQueue;
    }
}

