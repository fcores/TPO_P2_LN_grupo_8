public class ColaDinamicaCircular<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int cantidad;

    public ColaDinamicaCircular() {
        frente = null;
        fin = null;
        cantidad = 0;
    }

    public void inicializarCola() {
        frente = null;
        fin = null;
        cantidad = 0;
    }

    public void acolar(T x) {
        Nodo<T> nuevoNodo = new Nodo<>(x);

        if (colaVacia()) {
            frente = nuevoNodo;
            fin = nuevoNodo;
            nuevoNodo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(nuevoNodo);
        } else {
            nuevoNodo.setAnterior(fin);
            nuevoNodo.setSiguiente(frente);
            fin.setSiguiente(nuevoNodo);
            frente.setAnterior(nuevoNodo);
            fin = nuevoNodo;
        }

        cantidad++;
    }

   public void desacolar() {
    if (!colaVacia()) {
        frente = frente.getSiguiente();
        fin.setSiguiente(frente);
        frente.setAnterior(fin);
        cantidad--;

        if (colaVacia()) {
            frente = null;
            fin = null;
            }
        } else {
        // La cola está vacía, se puede manejar un caso de error o lanzar una excepción
        System.out.println("Error: La cola está vacía, no se puede desacolar");
        }
    }

    
    public boolean colaVacia() {
        return (cantidad == 0);
    }

    public T frente() {
        if (!colaVacia()) {
            return frente.getDato();
        } else {
            // Como la cola está vacía lo podemos considerar como un caso de error o una excepción
            System.out.println("Error: La cola está vacía, no tiene frente");
            return null;
        }
    }
    
    public T fin() {
        if (!colaVacia()) {
            return fin.getDato();
        } else {
            // Como la cola está vacía lo podemos considerar como un caso de error o una excepción
            System.out.println("Error: La cola está vacía, no tiene fin");
            return null;
        }
    }

    public int cantidad() {
        return cantidad;
    }
}
