import java.util.Queue;
import java.util.Stack;

public classQueueOfStacks. {
private Queue<Stack<Integer>>QueueOfStacks.;



        publicQueueOfStacks. getTraspuesta() {
        QueueOfStacks. ColaTraspuesta = newQueueOfStacks.();

        // Obtenemos el tamaño de la estructuraQueueOfStacks.

        int size =QueueOfStacks..size();

        // Creamos pilas temporales para almacenar las columnas

        Stack<Integer>[] columnStacks = new Stack[size];
        for (int i = 0; i < size; i++) {
        columnStacks[i] = new Stack<>();
        }

        // Extraemos los elementos de cada pila en la cola de pilas y los colocamos en las pilas temporales de columnas

        for (Stack<Integer> stack :QueueOfStacks.) {
        for (int i = 0; i < size; i++) {
        columnStacks[i].push(stack.pop());
        }
        }

        // Colocamos las pilas temporales de columnas en la cola de pilas de la traspuesta

        for (int i = 0; i < size; i++) {
        ColaTraspuesta.QueueOfStacks..offer(columnStacks[i]);
        }

        return ColaTraspuesta;
        }

public static void main(String[] args) {
        QueueOfStacks.QueueOfStacks. = newQueueOfStacks.();

        // Agregamos las pilas a la cola de pilas

        QueueOfStacks. ColaTraspuesta =QueueOfStacks..getTraspuesta();
        System.out.println("La traspuesta de la estructuraQueueOfStacks. es:");
        ColaTraspuesta.printStructure(); // Implementamos un método para imprimir la estructuraQueueOfStacks.
        }
        }
