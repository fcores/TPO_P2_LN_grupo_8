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
