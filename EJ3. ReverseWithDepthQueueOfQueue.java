import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public static <E> void reverseWithDepth(QueueOfQueue<E> queueOfQueue) {
        Queue<Queue<E>> reversedQueueOfQueues = new LinkedList<>();

        while (!queueOfQueue.isEmpty()) {
            Queue<E> queue = queueOfQueue.getQueue();
            Stack<E> stack = new Stack<>();

            while (!queue.isEmpty()) {
                stack.push(queue.poll());
            }

            Queue<E> reversedQueue = new LinkedList<>();
            while (!stack.isEmpty()) {
                reversedQueue.offer(stack.pop());
            }

            reversedQueueOfQueues.offer(reversedQueue);
        }

        while (!reversedQueueOfQueues.isEmpty()) {
            queueOfQueue.addQueue(reversedQueueOfQueues.poll());
        }
    }
}
