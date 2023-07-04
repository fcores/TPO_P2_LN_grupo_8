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
    
    public void InicializarPila() {
        cantidad = 0;
    }

    public void Apilar(int x) {
        if (cantidad < capacidad) {
            pila[cantidad] = x;
            cantidad++;
        } else {
            // Como la pila está vacía lo podemos considerar como un caso de error o una excepción
            System.out.println("Error: Pila llena, no se puede apilar el elemento " + x);
        }
    }

    public void Desapilar() {
        if (!PilaVacia()) {
            cantidad--;
        } else {
            // Como la cola está vacía lo podemos considerar como un caso de error o una excepción
            System.out.println("Error: La pila está vacía, no se puede desapilar");
        }
    }

    public boolean PilaVacia() {
        return (cantidad == 0);
    }
    
    public int Tope() {
        if (!PilaVacia()) {
            return pila[cantidad - 1];
        } else {
            // Como la cola está vacía lo podemos considerar como un caso de error o una excepción
            System.out.println("Error: La pila está vacía, no tiene tope");
            return -1;
        }
    }
}
