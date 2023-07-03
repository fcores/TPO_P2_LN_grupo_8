package chiteado.coladepilas;

import chiteado.colas.ColaTDA;
import chiteado.pilas.PilaTF;

public interface QueueOfStacksTDA<T> {
    void InicializarCola(int n);
    void Acolar(PilaTF pila);
    void Desacolar();
    boolean ColaVacia();
    PilaTF Primero();
    void MostrarCola();
    ColaTDA Mediciones();
    void InvertirColaSinAux();
    boolean Capicua();
    boolean SonInversas(ColaTDA or2);
    void EliminarRepetidosConcurrentes();
}
