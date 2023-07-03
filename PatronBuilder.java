import java.util.*;

// Clase SetBuilder que implementa el patrón Builder para Set
class SetBuilder<T> {
    private Set<T> set;

    public SetBuilder() {
        set = new HashSet<>();
    }

    public SetBuilder<T> add(T element) {
        set.add(element);
        return this;
    }

    public SetBuilder<T> addAll(Set<T> elements) {
        set.addAll(elements);
        return this;
    }

    public Set<T> build() {
        return set;
    }
}

// Clase StackBuilder que implementa el patrón Builder para Stack
class StackBuilder<T> {
    private Stack<T> stack;

    public StackBuilder() {
        stack = new Stack<>();
    }

    public StackBuilder<T> add(T element) {
        stack.push(element);
        return this;
    }

    public StackBuilder<T> addAll(Set<T> elements) {
        for (T element : elements) {
            stack.push(element);
        }
        return this;
    }

    public Stack<T> build() {
        return stack;
    }
}

// Modificación de la clase Queue para constructor con cantidad variable de elementos
class QueueWithVarArgs<T> {
    private Queue<T> queue;

    public QueueWithVarArgs(T... elements) {
        queue = new LinkedList<>();
        for (T element : elements) {
            queue.add(element);
        }
    }

    public Queue<T> getQueue() {
        return queue;
    }
}

public class Main {
    public static void main(String[] args) {
        // Uso del patrón Builder con Set
        Set<String> mySet = new SetBuilder<String>()
                .add("A")
                .add("B")
                .addAll(new HashSet<>(Arrays.asList("C", "D")))
                .build();

        System.out.println("Set elements: " + mySet);

        // Uso del patrón Builder con Stack
        Stack<Integer> myStack = new StackBuilder<Integer>()
                .add(1)
                .add(2)
                .addAll(new HashSet<>(Arrays.asList(3, 4, 5)))
                .build();

        System.out.println("Stack elements: " + myStack);

        // Uso de la modificación de Queue con constructor de cantidad variable de elementos
        Queue<Integer> myQueue = new QueueWithVarArgs<>(1, 2, 3, 4, 5).getQueue();

        System.out.println("Queue elements: " + myQueue);
    }
}
