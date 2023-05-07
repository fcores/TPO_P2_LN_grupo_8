package chiteado.coladepilas;

import chiteado.colas.ColaTDA;
import chiteado.pilas.PilaTF;

public class QueueOfStacks<T> implements QueueOfStacksTDA{

    private PilaTF[] cola;
    int inx;

    public void InicializarCola(int n) {
        cola = new PilaTF[n];
        inx = 0;
    }

    public void Acolar(PilaTF pila) {
        for(int i=inx-1;i>=0;i--) {
            cola[i+1]=cola[i];
        }
        cola[0]=pila;
        inx++;
    }

    public void Desacolar() {inx--;}


    public boolean ColaVacia() {return (inx==0);}

    public PilaTF Primero() {
        return cola[inx-1];
    }

    public void MostrarCola() {

    }

    public ColaTDA Mediciones() {
        return null;
    }

    public void InvertirColaSinAux() {

    }

    public boolean Capicua() {
        return false;
    }

    public boolean SonInversas(ColaTDA or2) {
        return false;
    }

    public void EliminarRepetidosConcurrentes() {

    }
}
