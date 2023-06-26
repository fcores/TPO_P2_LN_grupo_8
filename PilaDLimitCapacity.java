package implementaciones.listas;

import api.PilaTDA;

public class PilaDinamicaLimitada implements PilaTDA {
    private int[] pila;
    private int capacidad;
    private int cantidad;

    public PilaDinamicaLimitada(int capacidadMaxima) {
        capacidad = capacidadMaxima;
        pila = new int[capacidad];
        cantidad = 0;
    }

    /**
     * @Costo: Constante
     **/
    public void InicializarPila() {
        cantidad = 0;
    }

    /**
     * @Costo: Constante (amortizado)
     **/
    public void Apilar(int x) {
        if (cantidad < capacidad) {
            pila[cantidad] = x;
            cantidad++;
        } else {
            // La pila está llena, se puede manejar un caso de error o lanzar una excepción
            System.out.println("Error: Pila llena, no se puede apilar el elemento " + x);
        }
    }

    /**
     * @Costo: Constante
     **/
    public void Desapilar() {
        if (!PilaVacia()) {
            cantidad--;
        } else {
            // La pila está vacía, se puede manejar un caso de error o lanzar una excepción
            System.out.println("Error: La pila está vacía, no se puede desapilar");
        }
    }

    /**
     * @Costo: Constante
     **/
    public boolean PilaVacia() {
        return (cantidad == 0);
    }

    /**
     * @Costo: Constante
     **/
    public int Tope() {
        if (!PilaVacia()) {
            return pila[cantidad - 1];
        } else {
            // La pila está vacía, se puede manejar un caso de error o lanzar una excepción
            System.out.println("Error: La pila está vacía, no tiene tope");
            return -1;
        }
    }
}
