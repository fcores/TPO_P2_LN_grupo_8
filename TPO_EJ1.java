package tpo.tpo_ej1;
import chiteado.pilas.PilaTF;
import chiteado.coladepilas.QueueOfStacks;

public class TPO_EJ1 {
    public static void main(String[] args) {
        //DEFINO LA CANTIDAD DE ELEMENTOS
        int capacidad = 3;

        //INICIALIZAMOS EL ARRAY DE PILAS
        PilaTF[] pilas = new PilaTF[capacidad];

        //INICIALIZAMOS LAS PILAS Y LE AGREGAMOS VALORES
        PilaTF pila1 = new PilaTF();
        PilaTF pila2 = new PilaTF();
        PilaTF pila3 = new PilaTF();

        pila1.InicializarPila();
        pila2.InicializarPila();
        pila3.InicializarPila();

        pila1.Apilar(54);
        pila1.Apilar(25);
        pila1.Apilar(4);

        pila2.Apilar(8);
        pila2.Apilar(15);
        pila2.Apilar(67);

        pila3.Apilar(98765);
        pila3.Apilar(87);
        pila3.Apilar(987);

        pilas[0] = pila1;
        pilas[1] = pila2;
        pilas[2] = pila3;

        //INICIALIZAMOS EL TDA COLADEPILAS
        QueueOfStacks coladepilas = new QueueOfStacks();
        coladepilas.InicializarCola(capacidad);

        //ACOLAMOS LAS PILAS EN LA COLA
        coladepilas.Acolar(pila1);
        coladepilas.Acolar(pila2);
        coladepilas.Acolar(pila3);

        //LLAMAMOS AL METODO DE CALCULO DE LA TRAZA
        int traza = calcularTrazaColaDePilas(coladepilas,capacidad);

        //IMPRIMIMOS POR PANTALLA EL CALCULO
        System.out.println("La traza de la Cola de Pilas es: " + traza);

    }

    //GENERAMOS UN METODO PARA EL CALCULO DE LA TRAZA
    public static int calcularTrazaColaDePilas(QueueOfStacks coladepilas,int n) {
        //INICIAMOS LAS VARIABLES DE TRAZA Y POSICION
        int traza = 0;
        int posicion = 0;

        //UTILIZAMOS UNA COLATEMPORAL PARA LUEGO RESTAURAR LA ORIGINAL
        QueueOfStacks colaTemporal = new QueueOfStacks();
        colaTemporal.InicializarCola(3);

        //MIENTRAS LA COLA NO ESTE VACIA ANALIZAMOS LOS VALORES
        while (!coladepilas.ColaVacia()) {
            PilaTF pila = coladepilas.Primero();
            PilaTF pilaTemporal = new PilaTF();
            pilaTemporal.InicializarPila();

            // VERIFICAMOS LA CANTIDAD DE ELEMENTOS CONTRA LA POSICION DE LA PILA
            if (posicion < pila.ContarElementos()) {
                // A PARTIR DE LA POSICION NOS LLEVAMOS EL ELEMENTO DE LA PILA
                traza += pila.ObtenerElemento(posicion);
                System.out.println(pila.ObtenerElemento(posicion));
            }

            // MOVEMOS LOS ELEMENTOS RESTANTES A UNA PILA TEMPORAL
            while (!pila.PilaVacia()) {
                pilaTemporal.Apilar(pila.Tope());
                pila.Desapilar();
            }

            // RESTAURAMOS LA PILA ORIGINAL
            while (!pilaTemporal.PilaVacia()) {
                pila.Apilar(pilaTemporal.Tope());
                pilaTemporal.Desapilar();
            }

            //DESACOLAMOS LA PILA Y CONTINUAMOS CON LA SIGUIENTE
            colaTemporal.Acolar(pila);
            coladepilas.Desacolar();
            posicion++;
        }
        //RESTAURAMOS LA COLA
        while (!colaTemporal.ColaVacia()) {
            coladepilas.Acolar(colaTemporal.Primero());
            colaTemporal.Desacolar();
        }

        //DEVOLVEMOS LA TRAZA
        return traza;
    }
}
